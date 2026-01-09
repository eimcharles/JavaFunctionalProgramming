package com.eimc.functionalInterfaces.functionalIdentities.transformer;

import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.domain.FuelType;
import com.eimc.domain.User;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ExampleTwo {

    /**
     *      BiFunction < T, U, R > interface
     *
     *      Represents a function that accepts two arguments (T and U)
     *      and produces a result of type R.
     *
     *      BiFunction is the "Transformer" of functional pipelines:
     *      - Calculation: Combining two values to produce a result
     *      - Aggregation: Merging two distinct objects into a single summary
     *      - Contextual Transformation: Using one object to guide the transformation of another
     *
     *      T (Input 1): The type of the first argument.
     *      U (Input 2): The type of the second argument.
     *      R (Output): The type of the result of the function.
     *
     *      A BiFunction transforms objects of type T and U into a result of type R
     *
     * */

    public static void main(String[] args) {

        ///  Example 1: Aggregation
        System.out.println("Example one: using the BiFunction < T, U, R > interface to create a booking confirmation");

        User charles = new User
                (UUID.randomUUID(), "Charles", "Eimer");

        Car mercedes = new Car
                ("123_5",
                        new BigDecimal("119.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        String charlesBookingConfirmation = bookingConfirmation.apply(charles, mercedes);

        System.out.println(charlesBookingConfirmation);
        System.out.println();

        ///  Example 2: Chaining
        System.out.println("Example two: using the BiFunction < T, U, R > interface to create a chained formatted booking confirmation");

        String charlesFormattedBookingConfirmation = bookingConfirmationFormatted.apply(charles, mercedes);

        System.out.println(charlesFormattedBookingConfirmation);
        System.out.println();

        ///  Example 3: Calculation
        System.out.println("Example three: using the BiFunction < T, U, R > interface to map the firstName and lastName to a user Object");

        User bobby = userMapper.apply("Bobby", "MacDinkel");
        System.out.println(bobby);
        System.out.println();

    }

    static BiFunction<User, Car, String> bookingConfirmation = (user, car) ->
            "Booking confirmed for " + user.getFirstName() + " " + user.getLastName() +
                    " for the " + car.getBrand() +
                    " with registration number: " + car.getRegistrationNumber();

    static Function<String, String> formatToLowerCase = String::toLowerCase;

    /**
     *      Chaining BiFunctions:
     *
     *      The process of connecting a BiFunction < T, U, R> to a Function < T, R >.
     *
     *      The Output (R) of the BiFunction must match the Input (T) of the chained Function.
     *
     *      BiFunction < A, B, C> .andThen( Function < C, D> ) results in a BiFunction < A, B, D>.
     *
     * */

    static BiFunction<User, Car, String> bookingConfirmationFormatted = bookingConfirmation.andThen(formatToLowerCase);

    static BiFunction<String, String, User> userMapper = (firstName, lastName) ->
            new User(UUID.randomUUID(), firstName, lastName);

}
