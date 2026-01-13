package com.eimc.streams.exercises;

import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExampleFive {

    public static void main(String[] args) {

        List<Car> carList = MockData.getCars();

        /// Example 1:
        System.out.println("Example one: print the carList");
        carList.stream().forEach(System.out::println);
        System.out.println();

        ///  Example 2: findAny() - when order doesn't matter
        System.out.println("Example two: using findAny() to find any occurrence of a Honda with status available");
        Optional<Car> anyAvailableHonda = carList.stream()
                .filter(car -> car.getBrand().equals(Brand.HONDA))
                .filter(car -> !car.isCarBooked())
                .findAny();

        anyAvailableHonda.ifPresentOrElse(System.out::println, () -> System.out.println("No Honda available for booking"));
        System.out.println();

        ///  Example 3: sort() - to sort alphabetically
        System.out.println("Example three: using findFirst() to find the first occurrence of a Mercedes with status available");
        List<Car> sortedCars = carList.stream()
                .sorted(Comparator.comparing(Car::getBrand))
                        .toList();

        sortedCars.forEach(System.out::println);
        System.out.println();

        ///  Example 4: findFirst() - when order matters
        System.out.println("Example four: using findFirst() to find the first occurrence of a Mercedes with status available in a sorted car list");
        Optional<Car> firstAvailableMercedes = carList.stream()
                ///  filter first
                .filter(car -> car.getBrand().equals(Brand.MERCEDES))
                .filter(car -> !car.isCarBooked())
                ///  Sort alphabetically second
                .sorted(Comparator.comparing(Car::getBrand))
                .findFirst();

        firstAvailableMercedes.ifPresentOrElse(System.out::println, () -> System.out.println("No Mercedes available for booking"));
        System.out.println();

    }
}
