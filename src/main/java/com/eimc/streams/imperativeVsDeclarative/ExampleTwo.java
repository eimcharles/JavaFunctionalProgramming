package com.eimc.streams.imperativeVsDeclarative;

import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.io.IOException;
import java.util.List;

public class ExampleTwo {

    public static void main(String[] args) {

        List<Car> carList = MockData.getCars();

        ///  Example 1:
        System.out.println("Example one: using the Stream class to filter cars by fuel type electric");
        List<Car> electricCars = carList.stream()
                .filter(Car::isElectric)
                .toList();

        electricCars.forEach(System.out::println);
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using the Stream class to filter cars by fuel type gasoline");
        List<Car> gasCars = carList.stream()
                .filter(Car::isGasoline)
                .toList();

        gasCars.forEach(System.out::println);
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: using the Stream class to filter unavailable cars");
        List<Car> bookedCars = carList.stream()
                .filter(Car::isCarBooked)
                .toList();

        bookedCars.forEach(System.out::println);
        System.out.println();

        ///  Example 4:
        System.out.println("Example four: using the Stream class to filter available cars");
        List<Car> availableCars = carList.stream()
                .filter(car -> !car.isCarBooked())
                .toList();

        availableCars.forEach(System.out::println);
        System.out.println();

        ///  Example 5:
        System.out.println("Example five: using the Stream class to filter cars by brand Honda");
        List<Car> hondaList = carList.stream()
                .filter(car -> car.getBrand() == Brand.HONDA)
                .toList();

        hondaList.forEach(System.out::println);
        System.out.println();

        ///  Example 6:
        System.out.println("Example six: using the Stream class to filter cars by brand Volkswagen");
        List<Car> volkswagenList = carList.stream()
                .filter(car -> car.getBrand() == Brand.VOLKSWAGEN)
                .toList();

        volkswagenList.forEach(System.out::println);
        System.out.println();

    }

}
