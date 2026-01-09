package com.eimc.streams.imperativeVsDeclarative;

import com.eimc.domain.Car;
import com.eimc.streams.mockData.MockData;
import com.eimc.domain.User;

import java.io.IOException;
import java.util.List;

public class ExampleOne {

    public static void main(String[] args) throws IOException {

        List<Car> carList = MockData.getCars();

        carList.forEach(System.out::println);
    }
}
