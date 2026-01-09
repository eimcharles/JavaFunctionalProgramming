package com.eimc.functionalInterfaces.functionalIdentities.gatekeeper;

import com.eimc.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ExampleTwo {

    public static void main(String[] args) {

        /**
         *      BiPredicate < T, U > interface
         *
         *      Represents a boolean-valued function that accepts
         *      two input arguments and returns a primitive boolean.
         *
         *      BiPredicate is the "Relational Gatekeeper" of functional pipelines:
         *      - Relational Validation: Checking if two objects are compatible
         *      - Authorization: Verifying ownership or permissions between two entities
         *      - Comparison Logic: Deciding if the state of T correlates with the state of U
         *
         *      T (Input 1): The type of the first argument to be tested.
         *      U (Input 2): The type of the second argument to be tested.
         *
         *      BiPredicate methods are pure functions:
         *      - No State Mutation
         *      - Deterministic
         *      - No Side effects
         *
         *      A BiPredicate handles the evaluation of a condition based on two inputs.
         *
         * */

        Car mercedes = new Car
                ("123_6",
                        new BigDecimal("139.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        User charles = new User(UUID.randomUUID(), "Charles", "Eimer");

        Booking charlesBooking =  new Booking(UUID.randomUUID(), charles, mercedes, LocalDateTime.now());

        ///  Example 1: State and Relational Validation
        System.out.println("Example one: using BiPredicate < T, U > to verify a booking is active and a car is linked to a booking before releasing the associated car and refunding the user");

        if (isBookingActive.test(charlesBooking) && isCarLinkedToBooking.test(mercedes, charlesBooking)) {
            System.out.println("Booking is currently active and is linked to user " + charlesBooking.getUser().getFirstName() + " with car registration number " + charlesBooking.getCar().getRegistrationNumber());
            releaseCarFromBookingAndRefundUser.accept(mercedes, charlesBooking);
        }
        System.out.println();

        ///  Example 2: Authorization
        System.out.println("Example two: using BiPredicate < T, U > to verify authorization to release a car from a booking and refund a user");

        if (isUserAuthorizedForRefund.test(charles, charlesBooking)) {
            System.out.println("User " + charles.getFirstName() + " is authorized for refund, userId matches booking userId");
            releaseCarFromBookingAndRefundUser.accept(mercedes, charlesBooking);
        } else {
            System.out.println("Refund authorization denied, user not authorized for refund");
        }
        System.out.println();

        ///  Example 3: Comparison
        System.out.println("Example three: using BiPredicate < T, U > to verify comparison between a car object and a booking object");

        if (doesBookingPricePerDayMatchCar.test(mercedes, charlesBooking)) {
            System.out.println("Mercedes rental price per day and booking price per day match");
            System.out.println("Mercedes has rental price per day of " + mercedes.getRentalPricePerDay());
            System.out.println("Booking number " + charlesBooking.getUserBookingID() + " has rental price per day of " + charlesBooking.getCar().getRentalPricePerDay());
        } else {
            System.out.println("Mercedes price and booking price do not match");
        }
        System.out.println();

    }

    static BiPredicate<Car, Booking> doesBookingPricePerDayMatchCar = (car, booking) ->
            car.getRentalPricePerDay().equals(booking.getCar().getRentalPricePerDay());

    static BiPredicate<User, Booking> isUserAuthorizedForRefund = (user, booking) ->
            user.getUserId().equals(booking.getUser().getUserId());

    static BiPredicate<Car, Booking> isCarLinkedToBooking = (car, booking) ->
            booking.getCar().getRegistrationNumber().equals(car.getRegistrationNumber());

    static Predicate<Booking> isBookingActive = Booking::isBookingActive;

    static BiConsumer<Car, Booking> releaseCarFromBooking =  (car, booking) -> {
        car.setCarBooked(false);
        booking.cancelBooking();
        System.out.println("Booking number %s cancelled".formatted(booking.getUserBookingID()));
    };

    static BiConsumer<Car, Booking> refundUser = (car, booking) -> {
        System.out.println("Processing refund for booking: " + booking.getUserBookingID()
                + " for car with registration number " + car.getRegistrationNumber());
    };

    static BiConsumer<Car, Booking> releaseCarFromBookingAndRefundUser = releaseCarFromBooking.andThen(refundUser);

}
