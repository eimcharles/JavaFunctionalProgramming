package com.eimc.streams.exerciseTwo;

import java.util.List;
import java.util.stream.Collectors;

public class ExampleOne {

    public static void main(String[] args) {

        List<String> names = List.of("charles", "larry", "bob");

        ///  Example 1: imperative
        joiningStrings(names);

        ///  Example 2: declarative
        joiningStringsWithStreams(names);
    }

    public static void joiningStrings(List<String> namesList) {

        String joinedNames = "";

        for (String name : namesList) {
            String nameWithCapital = name.substring(0,1).toUpperCase() + name.substring(1);
            joinedNames += nameWithCapital + ", ";
        }

        System.out.println(joinedNames.substring(0, joinedNames.length() - 2));
    }

    public static void joiningStringsWithStreams(List<String> namesList) {

        String joinedNames = namesList.stream().
                map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(Collectors.joining(", "));

        System.out.println(joinedNames);
    }

}
