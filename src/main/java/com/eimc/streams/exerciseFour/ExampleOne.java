package com.eimc.streams.exerciseFour;


import java.util.ArrayList;
import java.util.List;

public class ExampleOne {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Alice", "Johnson", "alice.j@example.com", 28, Gender.FEMALE),
                new Person("Marcus", "Smith", "m.smith@techcorp.com", 34, Gender.MALE),
                new Person("Riley", "Vance", "r.vance@startup.io", 22, Gender.MALE),
                new Person("Elena", "Rodriguez", "elena.rod@webmail.com", 45, Gender.FEMALE)
        );

        ///  Example 1: convert from imperative to declarative
        List<Person> femalesList1 = new ArrayList<>();

        people.forEach(person -> {
            var isGender = person.getGender() == Gender.FEMALE;
            if (isGender) {
                femalesList1.add(person);
            }
        });

        femalesList1.forEach(System.out::println);
        System.out.println();

        ///  Example 1: converting to declarative
        List<Person> femaleList2 = people.stream()
                .filter(person
                        -> person.getGender().equals(Gender.FEMALE))
                .toList();

        femaleList2.forEach(System.out::println);
        System.out.println();

    }
    
}
