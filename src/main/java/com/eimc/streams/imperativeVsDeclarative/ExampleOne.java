package com.eimc.streams.imperativeVsDeclarative;


import com.eimc.domain.Brand;
import com.eimc.domain.Car;
import com.eimc.domain.User;
import com.eimc.streams.mockData.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExampleOne {

    public static void main(String[] args) throws IOException {

        List<User> userList = MockData.getUsers();
        List<Car> carList = MockData.getCars();

        ///  Example 1:
        System.out.println("Example one: using the Stream class to display 2 users from users.json file");
        userList.stream().
                limit(2).
                forEach(System.out::println);

        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using the Stream class to display 2 cars from cars.json file");
        carList.stream().
                limit(2).
                forEach(System.out::println);

        System.out.println();

        ///  Example 3:
        System.out.println("Example three: declarative approach to filter cars by brand");
        declarativeApproach(carList);
        System.out.println();

        ///  Example 4:
        System.out.println("Example four: imperative approach to filter cars by brand");
        imperativeApproach(carList);
        System.out.println();

    }

    static void imperativeApproach(List<Car> carList) {

        List<Car> mercedesList = new ArrayList<>();

        int mercedesCount = 0;
        int limit = 3;

        for (int i = 0; i < carList.size(); i++) {

            if (carList.get(i).getBrand() == Brand.MERCEDES) {

                mercedesList.add(carList.get(i));
                mercedesCount++;

                if (mercedesCount == limit){
                    break;
                }
            }
        }

        mercedesList.forEach(System.out::println);
    }

    static void declarativeApproach(List<Car> carList) {

        /// Order of operations matters
        List<Car> mercedesList = carList.stream()
                .filter( car -> car.getBrand() == Brand.MERCEDES)
                .limit(3)
                .toList();

        mercedesList.forEach(System.out::println);
    }

}
