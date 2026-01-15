package com.eimc.streams.transformations;

import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionExample {

    public static void main(String[] args) {

        List<Car> carList = MockData.getCars();

        /// Example 1: using partitioningBy() to split cars into two groups based on price
        System.out.println("Example one: sorting and using partitioningBy() to partition cars into groups based on a rental price per day");

        Map<Boolean, List<Car>> partitionedCars = carList.stream()
                .sorted(Comparator.comparing(Car::getRentalPricePerDay))
                ///  partitioningBy(predicate)
                .collect(Collectors.partitioningBy(car -> car.getRentalPricePerDay().doubleValue() > 100
                ));

        ///  partitionedCars.get(true) returns cars that meet the predicate
        System.out.println("Cars with rental price per day greater than 100$");
        partitionedCars.get(true).forEach(System.out::println);

        System.out.println();

        ///  partitionedCars.get(false) returns cars that don't meet the predicate
        System.out.println("Cars with rental price per day less than or equal to 100$");
        partitionedCars.get(false).forEach(System.out::println);

    }
}
