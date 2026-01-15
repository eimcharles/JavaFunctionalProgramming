package com.eimc.streams.transformations;

import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ReduceExample {

    public static void main(String[] args) {

        ///  reduce() allows to produce one result from a sequence of elements

        List<Car> carList = MockData.getCars();

        ///  Example 1:
        System.out.println("Example one: mapping a car object to a double and returning the average rental price per day for the carList");
        BigDecimal averageCarRentalPricePerDay = carList.stream()
                ///  Convert each car to its price per day
                .map(Car::getRentalPricePerDay)
                ///  Add the current total to the sequence
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ///  Divide by size with 2 decimal points and round up
                        .divide(BigDecimal.valueOf(carList.size()), 2, RoundingMode.HALF_UP);

        System.out.println("The average price per day for a rental is: " + averageCarRentalPricePerDay);

    }

}
