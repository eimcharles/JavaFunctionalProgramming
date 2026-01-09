package com.eimc.functionalInterfaces.combinatorPattern;

import com.eimc.domain.User;

import java.util.List;
import java.util.UUID;

import static com.eimc.functionalInterfaces.combinatorPattern.UserValidator.*;


public class Main {

    public static void main(String[] args) {

        List<User> userList = List.of(

                /// Valid User
                new User(UUID.randomUUID(), "Charles", "Eimer"),
                new User(UUID.randomUUID(), "Jerry", "LeBlond"),
                new User(UUID.randomUUID(), "Larry", "LeBlond"),

                /// Invalid User
                new User(null, "Bob", "LeBlond"),
                new User(UUID.randomUUID(), "Support", "User"),
                new User(UUID.randomUUID(), "Admin", null)

        );

        /// Instantiate concrete class for reserved names
        ReservedFirstNamesValidator reservedFirstNamesValidator = new ReservedFirstNamesValidator();

        /// Chain using the Combinator Pattern to apply all checks for valid user that doesn't use reserved first names
        UserValidator validatorChain = hasValidId()
                .and(hasValidFirstName())
                .and(hasValidLastName())
                .and(reservedFirstNamesValidator);

        ///  Use Stream to filter the list for valid users
        List<User> validUsers = userList.stream()
                .filter(validatorChain)
                .toList();

        ///  Use Stream to filter the list for invalid users
        List<User> invalidUsers = userList.stream()
                .filter(validatorChain.negate())
                .toList();

        ///  Print results
        validUsers.forEach(u ->
                System.out.println("Valid User: " + u.getFirstName()
                        + " " + u.getLastName()
                        + " " + u.getUserId()));

        System.out.println();

        invalidUsers.forEach(u ->
                System.out.println("Invalid User: "
                        + u.getFirstName()
                        + " " + u.getLastName()
                        + " " + u.getUserId()));
    }

}
