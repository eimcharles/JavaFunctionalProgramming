package com.eimc.streams.transformations;

import com.eimc.domain.Booking;
import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;

import java.util.List;

public class BookingExample {

    public static void main(String[] args) {

        List<Booking> bookingList = MockData.getBookings();
        List<Car> carList = MockData.getCars();

        /// Example 1:
        System.out.println("Example one: display all bookings from the bookingList");
        bookingList.forEach(System.out::println);
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: display all active booking from the bookingList");
        List<Booking> activeBookings = bookingList
                .stream()
                .filter(Booking::isBookingActive)
                .toList();

        activeBookings.forEach(System.out::println);
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: display all booked cars associated to a booking from the bookingList");
        List<Car> bookedCars = activeBookings.stream()
                ///  Takes a booking a returns the associated car object
                .map(booking -> booking.getCar())
                .toList();

        bookedCars.forEach(System.out::println);
        System.out.println();

        ///  Example 4: return the available cars based on the booked cars list
        System.out.println("Example four: display all available cars in the carList by comparing them to the booked cars in the bookingList");
        List<Car> availableCars = carList.stream()
                ///  Filter the available cars based on booked cars
                .filter(car -> !bookedCars.contains(car))
                .toList();

        availableCars.forEach(System.out::println);
        System.out.println();

        ///  Example 5: look at the car list and get all available cars
        System.out.println("Example five: display all available cars in carList");
        List<Car> availableCarsInCarList = carList.stream()
                .filter(car -> !car.isCarBooked())
                .toList();

        availableCarsInCarList.forEach(System.out::println);
        System.out.println();

    }
}
