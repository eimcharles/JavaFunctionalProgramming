package functionalInterfaces.functionalIdentities.gatekeeper;

import domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
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
         *
         *      - Filter Logic: Deciding what data stays or goes
         *      - Validation: Checking if an object meets requirements
         *      - Conditional Execution: Deciding if an action should trigger
         *
         *      T (Input): The type of the argument to be tested.
         *
         *      Predicate methods are pure functions:
         *
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

        ///  Example 1:
        System.out.println("Example one: using Predicate < T > interface to test a condition");

        if (isElectric.test(mercedes))
            System.out.println(mercedes.getBrand() + " is electric " + mercedes.isElectric());
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using Predicate < T > interface to test a condition");

        if (isCarAvailable.test(mercedes))
            System.out.println(mercedes.getBrand() + " is booked " + mercedes.isCarBooked());
        else {
            System.out.println(mercedes.getBrand() + " is booked " + mercedes.isCarBooked());
        }
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: using Predicate < T > interface to test two conditions using definition time chaining");

        if (IsElectricAndCarAvailable.test(mercedes))
            System.out.println(mercedes.getBrand() + " is electric " + mercedes.isElectric() + " and booked " + mercedes.isCarBooked());
        else {
            System.out.println(mercedes.getBrand() + " is electric " + mercedes.isElectric() + " and booked " + mercedes.isCarBooked());
        }
        System.out.println();

        ///  Example 4:
        System.out.println("Example four: using Predicate < T > interface to test a condition");

        if (isBookingActive.test(charlesBooking))
            System.out.println("Booking for " + charlesBooking.getUser().getFirstName() + " is active " + charlesBooking.isBookingActive());
        System.out.println();

    }

    static Predicate<Car> isElectric = car -> car.getFuelType() == FuelType.ELECTRIC;

    static Predicate<Car> isCarAvailable = Car::isCarBooked;

    static Predicate<Car> IsElectricAndCarAvailable = isElectric.and(isCarAvailable);

    static Predicate<Booking> isBookingActive = Booking::isBookingActive;

}
