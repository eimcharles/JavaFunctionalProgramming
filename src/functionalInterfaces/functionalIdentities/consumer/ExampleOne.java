package functionalInterfaces.functionalIdentities.consumer;

import domain.Brand;
import domain.Car;
import domain.FuelType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ExampleOne {

    static List<Car> carList = new ArrayList<>();

    public static void main(String[] args) {

        /**
         *      Consumer < T > interface
         *
         *      Represents an operation that accepts
         *      a single input argument and returns no result (void).
         *
         *      Consumer is expected to operate via side effects:
         *
         *          - Changes world outside the function
         *
         *      T (Input): The type of the argument to be consumed.
         *
         *      Consumer methods are impure functions:
         *
         *          - State Mutation
         *          - Collection modification
         *          - Broadcasting (e.g. Logging)
         *
         *      A Consumer handles an object and performs a side effect.
         *
         * */

        Car mercedes = new Car
                ("123_5",
                        new BigDecimal("139.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        Car volkswagen = new Car
                ("123_6",
                        new BigDecimal("119.00"), Brand.VOLKSWAGEN, FuelType.GASOLINE);

        ///  Example 1 Broadcasting:
        System.out.println("Example one: using Consumer < T > interface to process a booking and display to console");
        processBooking.accept(mercedes);
        System.out.println();

        /// Example 2 State Mutation:
        System.out.println("Example two: using Consumer < T > interface to update the state of a Car Object");
        System.out.println(mercedes);
        updateCarStatus.accept(mercedes);
        System.out.println(mercedes);
        System.out.println();

        /// Example 3 Chaining:
        System.out.println("Example three: using Consumer < T > interface to chain the booking process and update the car status");
        System.out.println(volkswagen);
        processBookingAndUpdateCarStatus.accept(volkswagen);
        System.out.println(volkswagen);
        System.out.println();

        /// Example 4 Collection modification:
        System.out.println("Example four: using Consumer < T > interface to modify a collection carList");
        addCarToCarList.accept(mercedes);
        addCarToCarList.accept(volkswagen);
        carList.forEach(System.out::println);

    }

    /**
     *     Using the Consumer functional interface to
     *     define an anonymous class processBooking
     *     which invokes accept() by use of a lambda.
     **
     *     Replaces the generic T with Car
     *     Signature is now (Car) -> void.
     *
     *     Consumer < Car > -> Shape
     *     processBooking -> Reference variable pointing to instance of anonymous class
     *     Implementation -> Lambda
     *
     * */

    static Consumer<Car> processBooking = car -> System.out.println("Processing booking for car with registration number: " + car.getRegistrationNumber());

    static Consumer<Car> updateCarStatus = car -> car.setCarBooked(true);

    static Consumer<Car> processBookingAndUpdateCarStatus = processBooking.andThen(updateCarStatus);

    static Consumer<Car> addCarToCarList = car -> carList.add(car);

}
