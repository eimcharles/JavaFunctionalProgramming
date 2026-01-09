package com.eimc.functionalInterfaces.javaCallbackFunctions;



import com.eimc.domain.User;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExampleTwo {

    /**
     *      Inversion of control:
     *      - The caller dictates the rules to the method.
     *
     *      The Main method acts like a container
     *      that injects specific validation
     *      and behavioral dependencies
     *      into the helloUser method.
     *
     *      The Main method defines
     *      the "how" and "what" and
     *      helloUser defines the
     *      "when".
     *
     *      Ioc promotes loose coupling
     *      for dependencies.
     *
     *      Traditional Programming:
     *      - The method dictates the rules to the caller.
     *
     *      The helloUser method act like a "Silo"
     *      where behavior is hardcoded
     *      internally.
     *
     *      The helloUser defines
     *      the "how" and "when"
     *      and "what".
     *
     *      This results in tight coupling,
     *      changes to "how", "when" and
     *      "what" require modifying the
     *      method itself.
     *
     *      This violates the Open-Closed Principle,
     *      as the method is not open for extension
     *      without modifying its source code.
     */

    public static void main(String[] args) {

        User invalidUser = new User(UUID.randomUUID(), "Jerry", null);

        helloUser(invalidUser,

                ///  Loose coupling - Validation Dependency
                user -> user.getLastName() != null,

                ///  Loose coupling - Strategy Dependency
                user -> System.out.println(user.getFirstName() + " you must have a last name")

                );

    }

    static void helloUser(User user, Predicate<User> validator, Consumer<User> callback) {
        if (validator.test(user)) {
            System.out.println("Hello " + user.getFirstName() + " " + user.getLastName());
        } else {
            callback.accept(user);
        }
    }

    static void helloUser(User user) {
        if (user.getLastName() != null) {
            System.out.println("Hello " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println(user.getFirstName() + " you must have a last name");
        }
    }
}
