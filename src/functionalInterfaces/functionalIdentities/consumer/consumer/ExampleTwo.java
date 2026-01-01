package functionalInterfaces.functionalIdentities.consumer.consumer;

import domain.Brand;
import domain.Car;
import domain.FuelType;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ExampleTwo {

    public static void main(String[] args) {

        /**
         *      Definition-Time Chaining: used to create "Atomic Operations":
         *          - Packages multiple steps into a single, reusable "Logic-Object."
         *
         *      Execution-Time Chaining: used to define "Conditional Workflows":
         *          - Second action depends on a condition that only becomes known after the first action occurs.
         * */

        Car mercedes = new Car
                ("123_6",
                        new BigDecimal("139.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        Car bmw = new Car
                ("123_7",
                        new BigDecimal("129.00"), Brand.BMW, FuelType.ELECTRIC);

        Car honda = new Car
                ("123_8",
                        new BigDecimal("99.00"), Brand.HONDA, FuelType.GASOLINE);

        /// Example 1:  Definition-Time Chaining
        System.out.println("Example one: using Consumer < T > for definition-time chaining");
        processBookingAndUpdateCarStatus.accept(mercedes);
        processBookingAndUpdateCarStatus.accept(bmw);
        processBookingAndUpdateCarStatus.accept(honda);
        System.out.println();

        /// Example 2: Execution-Time Chaining using the Stream class
        System.out.println("Example two: using Consumer < T > and the Stream class for execution-time chaining ");
        Stream.of(mercedes, bmw, honda)                                                     ///  Conveyor belt of Car objects
                .filter(car -> car.getRentalPricePerDay()
                        .compareTo(new BigDecimal("120.00")) > 0)                       /// The "Conditional" workflow
                .peek(processBooking)                                                       /// Mapped to Consumer.accept()
                .peek(updateCarStatus)                                                      /// Mapped to Consumer.accept()
                .forEach(System.out::println);                                              /// Mapped to Consumer.accept()

    }

    static Consumer<Car> processBooking =
            car -> System.out.println("Processing booking for car with registration number: " + car.getRegistrationNumber());

    static Consumer<Car> updateCarStatus =
            car -> car.setCarBooked(true);

    /**
     *      Chaining with Consumer Interface,
     *      a sequence of actions on the same object.
     * */

    static Consumer<Car> processBookingAndUpdateCarStatus = processBooking.andThen(updateCarStatus);

}
