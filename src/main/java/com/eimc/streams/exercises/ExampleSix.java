package com.eimc.streams.exercises;

import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.math.BigDecimal;
import java.util.List;

public class ExampleSix {

    public static void main(String[] args) {

        List<Car> carList = MockData.getCars();

        /// Example 1:
        System.out.println("Example one: print the carList");
        carList.stream().forEach(System.out::println);
        System.out.println();

        /// Example 2: anyMatch() - At least one match is found
        System.out.println("Example two: using anyMatch() to check if the carList contains at least one car who's rental price per day is less than 50$ ");
        boolean hasCheapElectric = carList.stream()
                .anyMatch(car -> car.getRentalPricePerDay().compareTo(new BigDecimal("50")) < 0);

        System.out.println("Are there any cheap cars under 50$? " + hasCheapElectric);
        System.out.println();

        /// Example 3: allMatch() - Everything matches
        System.out.println("Example three: using allMatch() to check if the carList contains only electric cars");
        boolean IsAllElectricCarList = carList.stream()
                .allMatch(Car::isElectric);

        System.out.println("Does the carList only contain electric cars? " + IsAllElectricCarList);
        System.out.println();

        /// Example 4: noneMatch() - Nothing matches
        System.out.println("Example four: using noneMatch() to check if the carList doesn't contain cars that have a rental price per day of 0$");
        boolean containsFreeCars = carList.stream()
                .noneMatch(car -> car.getRentalPricePerDay().compareTo(BigDecimal.ZERO) == 0);

        System.out.println("All cars in the the carList have a price not equal to 0? " + containsFreeCars);
        System.out.println();

    }

}
