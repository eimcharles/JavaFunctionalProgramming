package com.eimc.streams.exercises;

import com.eimc.domain.User;
import com.eimc.streams.mockData.MockData;

import java.util.List;
import java.util.stream.IntStream;

public class ExampleOne {

    public static void main(String[] args) {

        List<User> userList = MockData.getUsers();

        /// Example 1: range() is an exclusive range
        System.out.println("Example one: using the IntStream.range() to iterate over a user list and display 5 users");
        IntStream.range(0, 5).forEach(index -> System.out.println(userList.get(index)));
        System.out.println();

        /// Example 2: rangeClosed() is an inclusive range
        System.out.println("Example two: using the IntStream.rangeClosed() to iterate over a user list and display 4 users");
        IntStream.rangeClosed(0, 3).forEach(index -> System.out.println(userList.get(index)));
        System.out.println();

        /// Example 3: using iterate() to access the counter i
        System.out.println("Example three: using the IntStream().iterate() to iterate over a user list and display every second user for a maximum of 5 users");
        IntStream.iterate(0, i -> i < userList.size(), i -> i + 2)
                .limit(5)
                .forEach(index -> System.out.println(userList.get(index)));
        System.out.println();

        /// Example 4: forEach() to iterate over all users
        System.out.println("Example four: using the forEach() to iterate over a user list and display all users");
        userList.forEach(System.out::println);
        System.out.println();

    }

}
