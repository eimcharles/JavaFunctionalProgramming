package com.eimc.streams.exerciseOne;


import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.domain.User;
import com.eimc.streams.mockData.MockData;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ExampleFour {

    public static void main(String[] args) {

        List<Car> carList = MockData.getCars();
        List<User> userList = MockData.getUsers();

        ///  Example 1:
        System.out.println("Example one: filtering electric cars and sorting them by price in ascending order");
        List<Car> sortedElectricCars = carList.stream()
                ///  filter first - least expensive
                .filter(Car::isElectric)
                ///  Then sort - more expensive
                .sorted(Comparator.comparing(Car::getRentalPricePerDay))
                .toList();

        sortedElectricCars.forEach(System.out::println);
        System.out.println();

        ///  Example 2: finds the first electric car that meet the pipeline conditions
        System.out.println("Example two: using findFirst() to return the first found electric car in the unsorted carList");
        Optional<Car> firstElectric = carList.stream()
                .filter(Car::isElectric)
                .findFirst();

        firstElectric.ifPresentOrElse(System.out::println, () -> System.out.println("No electric cars in list"));
        System.out.println();

        ///  Example 3: find the first electric car that meets the pipeline conditions
        System.out.println("Example three: using findFirst() to return the first found electric Honda under 100$ that is not booked in the carList");
        Optional<Car> firstCheapHonda = carList.stream()
                ///  Least expensive operations first
                .filter(Car::isElectric)
                .filter(car -> car.getBrand().equals(Brand.HONDA))
                .filter(car -> !car.isCarBooked())
                ///  More expensive operations last
                .filter(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("100")) < 0)
                .findFirst();

        firstCheapHonda.ifPresentOrElse(System.out::println, () -> System.out.println("No available electric Honda under $100 found"));
        System.out.println();

        ///  Example 4: using ifPresentOrElse() for null elements or an empty Optional
        System.out.println("Example four: using Optional< User > and findFirst() for a user id that doesn't exist");
        Optional<User> userIdNotFound = userList.stream()
                .filter(user -> user.getUserId().equals(UUID.randomUUID()))
                .findFirst();

        userIdNotFound.ifPresentOrElse(System.out::println, () -> System.out.println("User id doesnt exist"));
        System.out.println();

        /// Example 5: using orElseGet() to get a new user if all pipeline checks fail
        System.out.println("Example five: using findFirst() and a default value for a user id that doesn't exist");
        User defaultValueForUserNotFound = userList.stream()
                .filter(user -> user.getUserId().equals(UUID.randomUUID()))
                .findFirst()
                ///  Only created if the search returns empty - lazy evaluation
                .orElseGet(() -> new User(UUID.randomUUID(), "Null", "User"));

        System.out.println(defaultValueForUserNotFound);

    }

}
