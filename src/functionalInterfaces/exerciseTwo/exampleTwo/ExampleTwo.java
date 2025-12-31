package functionalInterfaces.exerciseTwo.exampleTwo;

import domain.Brand;
import domain.Car;
import domain.FuelType;
import domain.User;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ExampleTwo {

    /**
     *      BiFunction < T, U, R > interface
     *
     *      An extension of the Function interface that accepts two arguments.
     *
     *      Used for operations that combine or process two different inputs.
     *
     *      T (Input 1): The type of the first argument to the Function.
     *      U (Input 2): The type of the second argument to the Function.
     *      R (Output):  The type of the result produced by the Function.
     *
     **/

    public static void main(String[] args) {

        ///  Example 1:
        System.out.println("Example one: using the BiFunction < T, U, R > interface to create a booking confirmation");

        User charles = new User
                (UUID.randomUUID(), "Charles", "Eimer");

        Car mercedes = new Car
                ("123_5",
                        new BigDecimal("119.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        String charlesBookingConfirmation = bookingConfirmation.apply(charles, mercedes);

        System.out.println(charlesBookingConfirmation);
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using the BiFunction < T, U, R > interface to create a chained formatted booking confirmation");

        String charlesFormattedBookingConfirmation = bookingConfirmationFormatted.apply(charles, mercedes);

        System.out.println(charlesFormattedBookingConfirmation);
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: using the BiFunction < T, U, R > interface to map the firstName and lastName to a User Object");

        User bobby = userMapper.apply("Bobby", "MacDinkel");
        System.out.println(bobby);

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
