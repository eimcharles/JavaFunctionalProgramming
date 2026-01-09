package functionalInterfaces.javaCallbackFunctions;

import domain.User;

import java.util.UUID;
import java.util.function.Consumer;

public class ExampleOne {

    /**
     *      Callback implementation in Java using
     *      functional interfaces with:
     *
     *          - Anonymous Inner Class
     *          - Lambda
     */

    public static void main(String[] args) {

        User invalidUser = new User (UUID.randomUUID(), "Jerry", null);
        User validUser = new User (UUID.randomUUID(), "Jerry", "LeBlond");

        ///  Anonymous inner class
        System.out.println("Example one: Callback function in Java using anonymous inner classes");

        helloUser(invalidUser , new Consumer<User>() {

            @Override
            public void accept(User user) {
                System.out.println(user.getFirstName() + " you must have a last name");
            }

        });

        helloUser(validUser , new Consumer<User>() {

            @Override
            public void accept(User user) {
                System.out.println(user.getFirstName() + " you must have a last name");
            }

        });

        System.out.println();

        ///  Example 2: Using Lambdas
        System.out.println("Example two: Callback function in Java using Lambdas");

        helloUser(invalidUser, u -> System.out.println(u.getFirstName() + " you must have a last name"));

        helloUser(validUser, u -> System.out.println(u.getFirstName() + " you must have a last name"));

        System.out.println();

    }


    static void helloUser(User user, Consumer<User> callback) {

        if (user.getLastName() != null) {
            System.out.println("Hello " + user.getFirstName() + " " + user.getLastName());
        } else {
            callback.accept(user);
        }
    }

}
