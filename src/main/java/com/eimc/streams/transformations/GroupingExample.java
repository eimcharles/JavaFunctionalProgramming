package com.eimc.streams.transformations;

import com.eimc.domain.Booking;
import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {

    public static void main(String[] args) {

        List<Car> carList = MockData.getCars();
        List<Booking> bookingList = MockData.getBookings();

        ///  Example 1:
        System.out.println("Example one: using groupingBy() to group cars by brand and display the associated cars");
        Map<Brand, List<Car>> brandListMap = carList
                .stream()
                ///  Group by brand
                .collect(Collectors.groupingBy(Car::getBrand));

        brandListMap.forEach((brand, carBrandList) -> {

            System.out.println("Brand " + brand);
            carBrandList.forEach(System.out::println);
            System.out.println();

        });

        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using groupingBy() to group cars by brand and display the number of cars for each brand");
        Map<Brand, Long> brandCountMap = carList
                .stream()
                /// Classifier, Downstream collector to count each car for the given brand
                .collect(Collectors.groupingBy(Car::getBrand, Collectors.counting()));

        brandCountMap.forEach((brand, countByBrand) -> {
            System.out.println("Count for " + brand + ": " + countByBrand);
        });

        System.out.println();

        ///  Example 3:
        System.out.println("Example three: using groupingBy() to group cars by brand and display the average rental price per day for each brand");
        Map<Brand, Double> averagePricePerBrand = carList.stream()
                /// Group by brand and average the rental price per day for each brand
                .collect(Collectors.groupingBy(Car::getBrand, Collectors.averagingDouble(car ->
                                car.getRentalPricePerDay().doubleValue())
                ));

        averagePricePerBrand.forEach((brand, averageRentalPricePerDayByBrand) -> {
            System.out.println("Average rental price per day for " + brand + ": " + averageRentalPricePerDayByBrand + "$");
        });

        System.out.println();

        ///  Example 4:
        System.out.println("Example four: using groupingBy() to group all active car bookings by brand");
        Map<Brand, List<Booking>> activeBookings = bookingList.stream()
                .filter(Booking::isBookingActive)
                .collect(Collectors.groupingBy(
                booking -> booking.getCar().getBrand()));

        activeBookings.forEach((brand, activeBooking) -> {

            System.out.println("Active bookings by car Brand " + brand);
            activeBooking.forEach(System.out::println);
            System.out.println();

        });

        System.out.println();

        ///  Example 5:
        System.out.println("Example five: using summarizingDouble() to group cars by brand and get statistics for a given car brand");
        Map<Brand, DoubleSummaryStatistics> brandStatisticsMap = carList.stream()
                ///  Grouping cars, convert in to double and use summarizingDouble()
                .collect(Collectors.groupingBy(Car::getBrand, Collectors.summarizingDouble(car -> car.getRentalPricePerDay().doubleValue())
                ));

        brandStatisticsMap.forEach((brand, stats) -> {

            System.out.println("Statistics for " + brand);
            System.out.println("Number of cars: " + stats.getCount());
            System.out.println("Min rental price per day: " + stats.getMin() + "$");
            System.out.println("Max rental price per day: " + stats.getMax() + "$");
            System.out.println("Average rental price per day: " + stats.getAverage() + "$");
            System.out.println();
        });

        System.out.println();

    }
}
