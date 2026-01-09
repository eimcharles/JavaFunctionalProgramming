package com.eimc.functionalInterfaces.functionalIdentities.consumer;

import com.eimc.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;

public class ExampleThree {

    public static void main(String[] args) {

        /**
         *      BiConsumer < T, U > interface
         *
         *      Represents an operation that accepts
         *      two input arguments and returns no result (void).
         *
         *      BiConsumer is expected to operate via side effects.
         *
         *      T (Input): The type of the first argument to be consumed.
         *      U (Input): The type of the second argument to be consumed.
         *
         *      BiConsumer methods are impure functions:
         *      - Relational Logic
         *      - Map Processing
         *      - State Mutation across multiple identities
         *
         *      A BiConsumer handles the interaction between two distinct entities.
         *
         * */

        Car mercedes = new Car
                ("123_5",
                        new BigDecimal("139.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        Car bmw = new Car
                ("123_7",
                        new BigDecimal("129.00"), Brand.BMW, FuelType.ELECTRIC);

        User charles = new User(UUID.randomUUID(), "Charles", "Eimer");

        User jerry = new User(UUID.randomUUID(), "Jerry", "LeBlond");

        Booking charlesBooking =  new Booking(UUID.randomUUID(), charles, mercedes, LocalDateTime.now());

        ///  Example 1: Relational logic
        System.out.println("Example one: using the BiConsumer < T, U > to link two independent identities");
        userCar.accept(charles, mercedes);
        System.out.println();

        ///  Example 2: State mutation across multiple entities
        System.out.println("Example two: using the BiConsumer < T, U > to link two independent identities and modifying the internal state of one object");
        assignUserToCar.accept(charles, mercedes);
        System.out.println();

        ///  Example 3: Map Processing - Map represents a registry for active bookings for user to car relationships
        System.out.println("Example three: using the BiConsumer < T, U > for Map processing");
        Map<User, Car> activeBooking = Map.of(jerry, bmw);
        activeBooking.forEach(assignUserToCar);
        System.out.println();

        ///  Example 4: Relational logic and state mutation across multiple entities
        System.out.println("Example four: using the BiConsumer < T, U > to link two independent identities and modifying the internal state of both object");
        releaseCarFromBooking.accept(mercedes, charlesBooking);
        System.out.println();

        ///  Example 5: Definition time chaining
        System.out.println("Example five: using the BiConsumer < T, U > to link two independent identities and use definition-time chaining");
        releaseCarFromBookingAndRefundUser.accept(mercedes, charlesBooking);
        System.out.println();

    }

    static BiConsumer<User, Car> userCar = (user, car) -> {
        System.out.println(user.getFirstName() + " " + user.getLastName() +
                " requested the " + car.getBrand() +
                " with registration number " + car.getRegistrationNumber());
    };

    static BiConsumer<User, Car> assignUserToCar = (user, car) -> {
        car.setCarBooked(true);
        System.out.println("Booking confirmed for " + user.getFirstName()
                + " for car with registration number " + car.getRegistrationNumber());
    };

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
