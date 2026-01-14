package com.eimc.streams.transformations;

import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.domain.FuelType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FlatMapExample {

    private static final List<List<Car>> nestedCarByBrandList = List.of(

            List.of(
                    new Car("123_1", new BigDecimal("45.00"), Brand.VOLKSWAGEN, FuelType.GASOLINE),
                    new Car("123_6", new BigDecimal("39.99"), Brand.VOLKSWAGEN, FuelType.ELECTRIC),
                    new Car("123_11", new BigDecimal("42.50"), Brand.VOLKSWAGEN, FuelType.GASOLINE),
                    new Car("123_16", new BigDecimal("41.00"), Brand.VOLKSWAGEN, FuelType.ELECTRIC)
            ),

            List.of(
                    new Car("123_2", new BigDecimal("115.50"), Brand.BMW, FuelType.ELECTRIC),
                    new Car("123_7", new BigDecimal("130.00"), Brand.BMW, FuelType.GASOLINE),
                    new Car("123_12", new BigDecimal("99.00"), Brand.BMW, FuelType.ELECTRIC),
                    new Car("123_17", new BigDecimal("140.00"), Brand.BMW, FuelType.GASOLINE)
            ),

            List.of(
                    new Car("123_3", new BigDecimal("52.00"), Brand.MAZDA, FuelType.GASOLINE),
                    new Car("123_8", new BigDecimal("58.00"), Brand.MAZDA, FuelType.ELECTRIC),
                    new Car("123_13", new BigDecimal("54.00"), Brand.MAZDA, FuelType.GASOLINE),
                    new Car("123_18", new BigDecimal("57.50"), Brand.MAZDA, FuelType.GASOLINE)
            ),

            List.of(
                    new Car("123_4", new BigDecimal("48.75"), Brand.HONDA, FuelType.GASOLINE),
                    new Car("123_9", new BigDecimal("65.00"), Brand.HONDA, FuelType.ELECTRIC),
                    new Car("123_14", new BigDecimal("46.00"), Brand.HONDA, FuelType.GASOLINE),
                    new Car("123_19", new BigDecimal("49.00"), Brand.HONDA, FuelType.ELECTRIC)
            ),

            List.of(
                    new Car("123_5", new BigDecimal("180.00"), Brand.MERCEDES, FuelType.GASOLINE),
                    new Car("123_10", new BigDecimal("210.00"), Brand.MERCEDES, FuelType.ELECTRIC),
                    new Car("123_15", new BigDecimal("155.00"), Brand.MERCEDES, FuelType.GASOLINE),
                    new Car("123_20", new BigDecimal("195.00"), Brand.MERCEDES, FuelType.ELECTRIC)
            )
    );

    public static void main(String[] args) {

        /// flatMap() allows you to "flatten" nested collections into a single stream of objects

        /// Example 1:
        System.out.println("Example one: using imperative programming to flatten a 2D list");
        withoutFlapMap();
        System.out.println();

        /// Example 2:
        System.out.println("Example two: using flatMap() to flatten a 2D list");
        withFlatMap();
        System.out.println();

        /// Example 3:
        System.out.println("Example three: using flatMap() to flatten a 2D list and retrieve all electric cars");
        List<Car> electricCars = nestedCarByBrandList.stream()
                .flatMap(List::stream)
                .filter(car -> car.getFuelType() == FuelType.ELECTRIC)
                .toList();

        electricCars.forEach(System.out::println);

    }

    public static void withoutFlapMap(){

        List<Car> carList = new ArrayList<>();

        for (List<Car> cars : nestedCarByBrandList) {
            /// Iterate through each sub-list (brand group)
            /// Add all the current sublist into the carList
            carList.addAll(cars);
        }

        System.out.println(carList);
    }

    public static void withFlatMap() {

        ///  Flatten the inner lists into one stream of Car objects
        List<Car> flatList = nestedCarByBrandList.stream()
                ///  List is the data type that we are applying flatMap() operation on
                .flatMap(List::stream)
                .toList();

        System.out.println(flatList);
    }

}
