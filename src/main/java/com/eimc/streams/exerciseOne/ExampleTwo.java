package com.eimc.streams.exerciseOne;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleTwo {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, 2, 3, 100, 23, 93, 99);
        List<Integer> duplicateIntegerList = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        int minInlist;
        int maxInlist;

        /// Example 1: using a lambda
        System.out.println("Example one: using the min function to find the min value in a list");
        minInlist = integerList.stream().min((x,y) -> x.compareTo(y)).get();
        System.out.println("Min value in list: " + minInlist);

        /// method reference
        minInlist = integerList.stream().min(Integer::compareTo).get();
        System.out.println("Min value in list: " + minInlist);

        /// using the Comparator interface
        minInlist = integerList.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Min value in list: " + minInlist);
        System.out.println();

        /// Example 2: using a lambda
        System.out.println("Example two: using the max function to find the max value in a list");
        maxInlist = integerList.stream().max((x,y) -> x.compareTo(y)).get();
        System.out.println("Max value in list: " + maxInlist);

        /// using method reference
        maxInlist = integerList.stream().max(Integer::compareTo).get();
        System.out.println("Max value in list: " + maxInlist);

        /// using the Comparator interface
        maxInlist = integerList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Max value in list: " + maxInlist);
        System.out.println();

        /// Example 3: using distinct() to remove duplicates
        System.out.println("Example three: using distinct() to remove duplicate elements in a list");
        duplicateIntegerList.stream().distinct().toList().forEach(System.out::println);
        System.out.println();

        /// Example 4: list to set conversion
        System.out.println("Example four: converting a list to set to remove duplicate elements");
        duplicateIntegerList.stream().collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println();
    }
}
