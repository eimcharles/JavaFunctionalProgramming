package com.eimc.functionalInterfaces.functionalIdentities.supplier;

import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.domain.FuelType;
import com.eimc.domain.User;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ExampleOne {

    public static void main(String[] args) {

        /**
         *      Supplier < T > interface
         *
         *      Represents a function that provides a result of type T
         *      without accepting any input arguments.
         *
         *      T (Output): The type of the result provided by the supplier.
         *
         *      Supplier methods can be pure, but are frequently impure:
         *      - Object Instantiation (Factory patterns)
         *      - Data Retrieval (Database/API sourcing)
         *      - Deferred/Lazy Execution (Only running when needed)
         *
         *      A Supplier provides an object of type T
         *
         * */

        ///  Example 1: Object Instantiation
        System.out.println("Example one: using Supplier< T > interface to create User Objects");

        User user1 = charles.get();
        System.out.println(user1);
        User user2 = larry.get();
        System.out.println(user2);
        System.out.println();

        ///  Example 2: Object Instantiation and Lazy Execution with Definition-Time Chaining
        System.out.println("Example two: using Supplier< T > interface to create booked Car Objects using definition-time chaining");

        Car bookedCar1 = bookedMercedes.get();
        System.out.println(bookedCar1);
        Car bookedCar2 = bookedVolkswagen.get();
        System.out.println(bookedCar2);
        System.out.println();

        /// Example 3: Object Instantiation with Execution-Time Chaining
        System.out.println("Example Three: using Supplier< T > interface and the Steam class for execution-time composition");

        Stream.generate(mercedes)                           /// The Supplier (Source)
                .limit(1)                          /// The Flow Control
                .forEach(System.out::println);             /// The Consumer (Broadcasting)

        System.out.println();
    }

    static Supplier<User> charles = () -> new User
            (UUID.randomUUID(), "Charles", "Eimer");

    static Supplier<User> larry = () -> new User
            (UUID.randomUUID(), "Jerry", "LeBlond");

    static Supplier<Car> mercedes = () -> new Car
            ("123_5", new BigDecimal("119.00"), Brand.MERCEDES, FuelType.ELECTRIC);

    static Supplier<Car> volkswagen = () -> new Car
            ("123_6",  new BigDecimal("119.00"), Brand.VOLKSWAGEN, FuelType.ELECTRIC);

    /**
     *      Lazy Execution:
     *      - Logic is defined but not executed until .get() is invoked.
     *
     *      - Only invoked when creating and setting a mercedes to booked
     *        (Behavior that results in a car creating and state modification).
     *
     *      Definition-Time Chaining (via Composition):
     *      - Logic Flow: Supplier -> Internal Mutation -> Returned Object
     * */

    static Supplier<Car> bookedMercedes = ()-> {
        Car car = mercedes.get();
        car.setCarBooked(true);
        return car;
    };

    static Supplier<Car> bookedVolkswagen = ()-> {
        Car car = volkswagen.get();
        car.setCarBooked(true);
        return car;
    };

}
