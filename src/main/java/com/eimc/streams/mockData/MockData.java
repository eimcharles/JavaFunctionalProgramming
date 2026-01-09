package com.eimc.streams.mockData;

import com.eimc.domain.Car;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.eimc.domain.User;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<User> getUsers() throws IOException {

        // Locate the file in the src/main/resources folder and open a byte stream
        InputStream inputStream = Resources.getResource("users.json").openStream();

        // Read all bytes from the stream and convert them into a UTF-8 encoded String
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        // Create a Type marker to bypass Java's Type Erasure and preserve the List<User> structure
        Type listType = new TypeToken<ArrayList<User>>() {}.getType();

        // Parse the JSON string into Java User objects and return the list
        return new Gson().fromJson(json, listType);
    }

    public static List<Car> getCars() throws IOException {

        // Locate the file in the src/main/resources folder and open a byte stream
        InputStream inputStream = Resources.getResource("cars.json").openStream();

        // Read all bytes from the stream and convert them into a UTF-8 encoded String
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

        // Create a Type marker to bypass Java's Type Erasure and preserve the List<Car> structure
        Type listType = new TypeToken<ArrayList<Car>>() {}.getType();

        // Parse the JSON string into Java User objects and return the list
        return new Gson().fromJson(json, listType);
    }
}
