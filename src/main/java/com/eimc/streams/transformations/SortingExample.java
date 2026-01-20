package com.eimc.streams.transformations;

import com.eimc.domain.Admin;
import com.eimc.domain.Booking;
import com.eimc.domain.Car;
import com.eimc.domain.User;
import com.eimc.streams.mockData.MockData;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {

        List<User> userList = MockData.getUsers();
        List<Admin> adminList = MockData.getAdmins();
        List<Car> carList = MockData.getCars();
        List<Booking> bookingList = MockData.getBookings();


        ///  Example 1:
        System.out.println("Example one: sorting a list of user objects by first names alphabetically");
        userList.stream()
                .sorted(Comparator.comparing(User::getFirstName))
                .toList()
                .forEach(user -> System.out.println("User first name: " + user.getFirstName()));

        System.out.println();

        ///  Example 2:
        System.out.println("Example two: sorting a list of admin objects by email in reverse alphabetical order");
        adminList.stream()
                .sorted(Comparator.comparing(Admin::getEmail).reversed())
                .toList()
                .forEach(admin -> System.out.println("Email address: " + admin.getEmail()));

        System.out.println();

        ///  Example 3:
        System.out.println("Example three: sorting a list of booking objects by booking status active");
        bookingList.stream()
                .sorted(Comparator.comparing(booking -> !booking.isBookingActive()))
                .toList()
                .forEach(booking -> System.out.println("Booking id: " + booking.getUserBookingID() + "\tBooking status: " + booking.isBookingActive()));

        System.out.println();

        ///  Example 4:
        System.out.println("Example four: sorting a list of car objects by brand");
        carList.stream()
                .sorted(Comparator.comparing(Car::getBrand))
                .toList()
                .forEach(car -> System.out.println("Car brand: " + car.getBrand()));

        System.out.println();

        ///  Example 5:
        System.out.println("Example five: sorting a list of booking objects by booking date and booking status");
        bookingList.stream()
                .sorted(Comparator
                        .comparing(Booking::getBookingTime)
                        .thenComparing(Booking::isBookingActive))
                .toList()
                .forEach(booking ->
                        System.out.println("Booking date: " + booking.getBookingTime().format(DateTimeFormatter.ISO_LOCAL_DATE) + "\tBooking Status active: " + booking.isBookingActive()));

        System.out.println();

        ///  Example 6:
        System.out.println("Example six: sorting a list of cars to return the top 10 most expensive cars by brand");
        List<Car> top10MostExpensiveCarsByBrand = carList.stream()
                .filter(car -> car.getRentalPricePerDay().doubleValue() > 50)
                .sorted(Comparator.comparing(Car::getRentalPricePerDay).reversed()
                        .thenComparing(Car::getBrand))
                .limit(10)
                .toList();

        top10MostExpensiveCarsByBrand.forEach(car -> System.out.println(car.getBrand() + " rental price per day: " + car.getRentalPricePerDay() + "$"));
        System.out.println();
    }

}
