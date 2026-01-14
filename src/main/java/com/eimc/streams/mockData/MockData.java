package com.eimc.streams.mockData;

import com.eimc.domain.Admin;
import com.eimc.domain.Booking;
import com.eimc.domain.Car;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.eimc.domain.User;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockData {

    public static List<User> getUsers() {

        try {

            // Locate 'users.json' in the resources folder and open a data stream to read it
            InputStream inputStream = Resources.getResource("users.json").openStream();

            // Read all bytes from the stream and convert them into a UTF-8 encoded String
            String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

            // Create a Type marker to bypass Java's Type Erasure and preserve the List<User> structure
            Type listType = new TypeToken<ArrayList<User>>() {}.getType();

            // Convert the JSON text into User objects based on the defined listType
            List<User> userList = new Gson().fromJson(json, listType);

            // Return the list of users, or an empty list if the JSON file was empty/null
            return userList != null ? userList : Collections.emptyList();

        } catch (IOException e ) {

            System.err.println("Error loading users: " + e.getMessage());

            // Return an empty list after throwing exception
            return Collections.emptyList();

        }

    }

    public static List<Car> getCars() {

        try {

            InputStream inputStream = Resources.getResource("cars.json").openStream();
            String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            Type listType = new TypeToken<ArrayList<Car>>() {}.getType();
            List<Car> carList = new Gson().fromJson(json, listType);
            return carList != null ? carList : Collections.emptyList();

        } catch (IOException e) {

            System.err.println("Error loading cars: " + e.getMessage());
            return Collections.emptyList();
        }

    }

    public static List<Admin> getAdmins() {

        try {

            InputStream inputStream = Resources.getResource("admins.json").openStream();
            String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            Type listType = new TypeToken<ArrayList<Admin>>() {}.getType();
            List<Admin> adminList = new Gson().fromJson(json, listType);
            return adminList != null ? adminList : Collections.emptyList();

        } catch (IOException e ) {

            System.err.println("Error loading admins: " + e.getMessage());
            return Collections.emptyList();

        }

    }

    public static List<Booking> getBookings() {

        try {

            InputStream inputStream = Resources.getResource("bookings.json").openStream();
            String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            Type listType = new TypeToken<ArrayList<Booking>>() {}.getType();

            List<Booking> bookingList = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                            (jsonElement, type, context) ->
                                    LocalDateTime.parse(jsonElement.getAsString()))
                    .create()
                    .fromJson(json, listType);

            return bookingList != null ? bookingList : Collections.emptyList();

        } catch (IOException e) {

            System.err.println("Error loading bookings: " + e.getMessage());
            return Collections.emptyList();

        }
    }

}
