package com.eimc.functionalInterfaces.functionalIdentities.gatekeeper;

import com.eimc.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class ExampleOne {

    public static void main(String[] args) {

        /**
         *      Predicate < T > interface
         *
         *      Represents a boolean-valued function that accepts
         *      a single input argument and returns a primitive boolean.
         *
         *      Predicate is the "Gatekeeper" of functional pipelines:
         *      - Filter Logic (Streams): Deciding what data stays or goes
         *      - Validation: Checking if an object meets requirements
         *      - Conditional Execution: Deciding if an action should trigger
         *
         *      T (Input): The type of the argument to be tested.
         *
         *      Predicate methods are pure functions:
         *      - No State Mutation
         *      - Deterministic
         *
         *      A Predicate handles the evaluation of a condition
         *
         * */

        Car mercedes = new Car
                ("123_6",
                        new BigDecimal("139.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        User charles = new User(UUID.randomUUID(), "Charles", "Eimer");

        Booking charlesBooking =  new Booking(UUID.randomUUID(), charles, mercedes, LocalDateTime.now());

        ///  Example 1: Validation
        System.out.println("Example one: using Predicate < T > interface to test a condition");

        if (isElectric.test(mercedes))
            System.out.println(mercedes.getBrand() + " is electric ");
        System.out.println();

        ///  Example 2: Validation
        System.out.println("Example two: using Predicate < T > interface to test a condition");

        if (isCarBooked.test(mercedes))
            System.out.println(mercedes.getBrand() + " is already booked");
        else {
            System.out.println(mercedes.getBrand() + " is not booked and available");
        }
        System.out.println();

        ///  Example 3: Definition-Time Chaining
        System.out.println("Example three: using Predicate < T > interface to test two conditions using definition time chaining");

        if (isElectricAndIsCarBooked.test(mercedes))
            System.out.println(mercedes.getBrand() + " is electric and is already booked");
        else {
            System.out.println(mercedes.getBrand() + " is electric and is not booked and available");
        }
        System.out.println();

        ///  Example 4: Conditional execution
        System.out.println("Example four: using Predicate < T > for conditional execution");

        if (isBookingActive.test(charlesBooking))
            releaseCarFromBookingAndRefundUser.accept(mercedes, charlesBooking);
        System.out.println();

    }

    static Predicate<Car> isElectric = car -> car.getFuelType() == FuelType.ELECTRIC;

    static Predicate<Car> isCarBooked = Car::isCarBooked;

    static Predicate<Car> isElectricAndIsCarBooked = isElectric.and(isCarBooked);

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
