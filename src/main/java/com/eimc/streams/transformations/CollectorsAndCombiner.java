package com.eimc.streams.transformations;

import com.eimc.domain.Car;
import com.eimc.domain.User;
import com.eimc.streams.mockData.MockData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsAndCombiner {

    public static void main(String[] args) {

        List<User> userList = MockData.getUsers();
        List<Car> carList = MockData.getCars();

        ///  Example 1: breaking down the collect() method in the steam pipeline with lambdas
        userList.stream()
                .map(User::getUserId)
                .collect(

                        ///  Supplier - new List
                        ArrayList::new,
                        ///  BiConsumer - How do we add to the list
                        (userIDList, element) -> userIDList.add(element),
                        /// BiConsumer - How do we combine both lists
                        (list1, list2) -> list1.addAll(list2)

                );


        ///  Example 2: breaking down the collect() method in the steam pipeline with method referencing
        userList.stream()
                .map(User::getUserId)
                .collect(ArrayList::new, List::add, List::addAll);


        ///  Example 3: Collectors.toList() returns a mutable list
        userList.stream()
                .map(User::getUserId)
                .collect(Collectors.toList());


        ///  Example 4: toList() returns an immutable list
        userList.stream()
               .map(User::getUserId)
               .toList();


        ///  Example 5: Why streams are lazy, only runs when invoking terminal operator
        System.out.println(

                ///  Element by element
                    carList.stream()

                            /// Filters cars one by one
                            .filter(car -> {

                                System.out.println("Filtering " + car);
                                return car.getRentalPricePerDay().compareTo(new BigDecimal("100")) > 0;

                            })

                            /// Transformation only happens for one car at a time, that meets the filter condition.
                            .map(car -> {

                                System.out.println("Mapping " + car);
                                return car.getRentalPricePerDay();

                            })

                            ///  Filtered car is then added to the list, moves to next element
                            .toList());

    }

}
