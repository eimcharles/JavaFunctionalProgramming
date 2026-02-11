package com.eimc.streams.exerciseFive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class ExampleOne {

    public static void main(String[] args) {

        List<Employee> employeeList = List.of(

                ///  List.Of creates an immutable list

                new Employee(UUID.randomUUID(), "Alice Smith", "alice@example.com", "555-0101", new BigDecimal("75000"), "New York", "Female", LocalDateTime.of(1990, 5, 15, 9, 0), "Engineering", 34),
                new Employee(UUID.randomUUID(), "alexander Wright", "alex@example.com", "555-0102", new BigDecimal("62000"), "Chicago", "Male", LocalDateTime.of(1995, 8, 22, 10, 30), "Marketing", 29),
                new Employee(UUID.randomUUID(), "Aaron Jones", "aaron@example.com", "555-0103", new BigDecimal("88000"), "Seattle", "Male", LocalDateTime.of(1988, 12, 1, 8, 15), "Engineering", 36),
                new Employee(UUID.randomUUID(), "amanda Miller", "amanda@example.com", "555-0104", new BigDecimal("54000"), "Austin", "Female", LocalDateTime.of(1998, 3, 10, 14, 0), "Sales", 26),

                /// Names NOT starting with A/a
                new Employee(UUID.randomUUID(), "Bob Barker", "bob@example.com", "555-0201", new BigDecimal("50000"), "Cleveland", "Male", LocalDateTime.of(1970, 10, 20, 10, 0), "Entertainment", 54),
                new Employee(UUID.randomUUID(), "Catherine Zeta", "cat@example.com", "555-0202", new BigDecimal("110000"), "Miami", "Female", LocalDateTime.of(1982, 9, 25, 12, 0), "Legal", 42),
                new Employee(UUID.randomUUID(), "James Bond", "007@example.com", "555-0007", new BigDecimal("150000"), "London", "Male", LocalDateTime.of(1980, 1, 1, 0, 0), "Security", 44),
                new Employee(UUID.randomUUID(), "Sarah Connor", "sarah@sky.net", "555-0900", new BigDecimal("92000"), "Los Angeles", "Female", LocalDateTime.of(1985, 5, 12, 6, 30), "Operations", 39),
                new Employee(UUID.randomUUID(), "Brian O'Conner", "brian@example.com", "555-0203", new BigDecimal("67000"), "Miami", "Male", LocalDateTime.of(1992, 4, 14, 15, 0), "Logistics", 32)
        );

        List<String> employeeNames = listOfEmployeesNameStartingWithLetterA(employeeList);
        employeeNames.forEach(System.out::println);
    }

    /**
     *          Find the employee name that starts with 'a' or 'A' and
     *          sort based on their name using Java 8 streams API
     *          and take all the names into a single list
     * */

    public static List<String> listOfEmployeesNameStartingWithLetterA(List<Employee> employeeList) {

        if (employeeList == null){
            throw new RuntimeException("Employee List cannot be null");
        }

        ///  Check the employee list is not null
        ///  Check that the employee objects in the list are not null
        ///  Check if the employee names are not null

        ///  Check if the name starts with A or a using filter
        ///  Map the employee object to the employee name
        ///  Collect all the mapped employees and return a list

        return employeeList.stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.name() != null)
                .filter(employee -> employee.name().startsWith("A") || employee.name().startsWith("a"))
                .map(Employee::name)
                .sorted()
                .collect(Collectors.toList());
    }

}
