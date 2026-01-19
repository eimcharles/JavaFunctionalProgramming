package com.eimc.streams.exerciseOne;

import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class ExampleThree {

    public static void main(String[] args) {

        List<Car> carList = MockData.getCars();

        List<Car> expensiveCars;
        List<Car> cheapCars;
        List<Car> expensiveElectricCars;
        List<Car> expensiveGasCars;
        List<Car> cheapGasCars;

        ///  Example 1:
        System.out.println("Example one: using filter() to filter cars by fuel type electric");
        List<Car> electricCars = carList.stream()
                .filter(Car::isElectric)
                .toList();

        electricCars.forEach(System.out::println);
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using filter() to filter cars by rental price per day greater than 100$");
        expensiveCars = carList.stream()
                .filter(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("100")) > 0)
                .toList();

        expensiveCars.forEach(System.out::println);
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: using filter() to filter cars by rental price per day less than 100$");
        cheapCars = carList.stream()
                .filter(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("100")) < 0)
                .toList();

        cheapCars.forEach(System.out::println);
        System.out.println();

        ///  Example 4:
        System.out.println("Example four: using filter() to filter electric cars by rental price per day greater than 100$");
        expensiveElectricCars = carList.stream()
                .filter(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("100")) > 0)
                .filter(Car::isElectric)
                .toList();

        expensiveElectricCars.forEach(System.out::println);
        System.out.println();

        ///  Example 5:
        System.out.println("Example five: using filter() to filter gas cars by rental price per day less than 100$");
        cheapGasCars = carList.stream()
                .filter(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("100")) < 0)
                .filter(Car::isGasoline)
                .toList();

        cheapGasCars.forEach(System.out::println);
        System.out.println();

        ///  Example 6: using takeWhile() takes elements while a condition is met
        System.out.println("Example six: using takeWhile() takes elements as long as the condition is true, drops the rest of elements");
        cheapGasCars = carList.stream()
                .filter(Car::isGasoline)
                ///  Sort the cars in ascending order by rental price per day
                .sorted(Comparator.comparing(Car::getRentalPricePerDay))
                ///  Take all the cheap cars until the first car over 100$
                .takeWhile(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("100")) < 0)
                .toList();

        cheapGasCars.forEach(System.out::println);
        System.out.println();

        ///  Example 7: using dropWhile() drops elements while a condition is met
        System.out.println("Example seven: using dropWhile() drops elements as long as the condition is true, then collect the rest of elements");
        expensiveGasCars = carList.stream()
                .filter(Car::isGasoline)
                ///  Sort the cars in ascending order by rental price per day
                .sorted(Comparator.comparing(Car::getRentalPricePerDay))
                ///  Drop all the cheap cars until you hit the first car over 100$ and start collecting
                .dropWhile(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("100")) < 0)
                .toList();

        expensiveGasCars.forEach(System.out::println);
        System.out.println();

    }

}
