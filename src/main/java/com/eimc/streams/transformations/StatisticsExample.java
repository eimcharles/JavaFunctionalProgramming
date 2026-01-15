package com.eimc.streams.transformations;

import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class StatisticsExample {

    public static List<Car> carList = MockData.getCars();

    public static void main(String[] args) {

        long carBrandCount;

        ///  Example 1:
        System.out.println("Example one: using count() to count the number of BMW in the carList");
        carBrandCount = countCarsByBrand(Brand.BMW);
        System.out.println("BMW count in carList: " + carBrandCount);
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using count() to count the number of MERCEDES in the carList");
        carBrandCount = countCarsByBrand(Brand.MERCEDES);
        System.out.println("MERCEDES count in carList: " + carBrandCount);
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: using count() to count the number of VOLKSWAGEN in the carList");
        carBrandCount = countCarsByBrand(Brand.VOLKSWAGEN);
        System.out.println("VOLKSWAGEN count in carList: " + carBrandCount);
        System.out.println();

        ///  Example 4:
        System.out.println("Example four: using count() to count the number of HONDA in the carList");
        carBrandCount = countCarsByBrand(Brand.HONDA);
        System.out.println("HONDA count in carList: " + carBrandCount);
        System.out.println();

        ///  Example 5:
        System.out.println("Example five: using count() to count the number of MAZDA in the carList");
        carBrandCount = countCarsByBrand(Brand.MAZDA);
        System.out.println("MAZDA count in carList: " + carBrandCount);
        System.out.println();

        /// Example 6:
        System.out.println("Example six: using min() to find the least expensive car in the carList");
        Optional<BigDecimal> cheapestCar = carList.stream()
                .map(Car::getRentalPricePerDay)
                .min(Comparator.naturalOrder());

        cheapestCar.ifPresentOrElse(price -> System.out.println(price + "$"),
                () -> System.out.println("Unable to find least expensive car"));
        System.out.println();

        /// Example 7:
        System.out.println("Example seven: using max() to find the most expensive car in the carList");
        Optional<BigDecimal> mostExpensiveCar =  carList.stream()
                .map(Car::getRentalPricePerDay)
                .max(Comparator.naturalOrder());

        mostExpensiveCar.ifPresentOrElse(price -> System.out.println(price + "$"),
                () -> System.out.println("Unable to find most expensive car"));
        System.out.println();

        /// Example 8:
        System.out.println("Example eight: finding the average car rental price per day in the carList");
        BigDecimal averageCarRentalPricePerDay = carList.stream()
                .map(Car::getRentalPricePerDay)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(carList.size()), 2, RoundingMode.HALF_UP);

        System.out.println("The average car rental price per day for a rental is: " + averageCarRentalPricePerDay + "$");
        System.out.println();

        /// Example 9:
        System.out.println("Example nine: finding the total sum of rental prices per day in the carList");
        BigDecimal totalSumOfRentalCostsPerDay = carList.stream()
                .map(Car::getRentalPricePerDay)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("The total sum of all the rental prices per day is: " + totalSumOfRentalCostsPerDay + "$");
        System.out.println();

        /// Example 10:
        System.out.println("Example ten: using the summaryStatistics() method to get the most expensive rental price per day");
        DoubleSummaryStatistics doubleSummaryStatistics = carList.stream()
                .map(Car::getRentalPricePerDay)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();

        System.out.println(doubleSummaryStatistics.getMax() + "$");

    }

    public static long countCarsByBrand(Brand brand){
        return carList.stream()
                .filter(car -> car.getBrand()
                        .equals(brand))
                .count();
    };

}
