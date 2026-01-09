package com.eimc.functionalInterfaces.functionalIdentities.transformer;

import com.eimc.domain.User;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;

public class ExampleOne {

    /**
     *      Function < T, R > interface
     *
     *      Represents a function that accepts one argument of type T
     *      and produces a result of type R.
     *
     *      Function is the "Transformer" of functional pipelines:
     *      - Mapping: Converting an object from one type to another (Mapping User to UserDTO)
     *      - Extraction: Pulling a specific field or property out of a complex object
     *      - Conversion: Formatting data
     *
     *      T (Input): The type of the argument to the function.
     *      R (Output): The type of the result of the function.
     *
     *      Function methods are ideally pure:
     *      - Transformation-focused (Mapping input to output)
     *      - Deterministic
     *
     *      A Function transforms an object of type T into a result of type R
     *
     * */

    public static void main(String[] args) {

        ///  Example 1:
        System.out.println("Example one: using Function < T, R > interface to define a function incrementsNumberByOne");
        System.out.println(incrementsNumberByOne.apply(1));
        System.out.println();

        ///  Example 2: Chaining
        System.out.println("Example two: using Functions <T , R > to chain functions");
        System.out.println(incrementsByOneAndMultiplyByTen.apply(1));
        System.out.println();

        ///  Example 3: Execution-Time Chaining
        System.out.println("Example three: using Function < T, R > interface and Streams to manipulate Lists");
        List<Integer> integerListIncremented = Stream.of(4,5,6,7,8)
                .map(ExampleOne::incrementsNumberByOne)
                .toList();

        System.out.println(integerListIncremented);
        System.out.println();

        ///  Example 4: Extraction
        System.out.println("Example four: using Function < T, R > interface on the user object to extract the first name");
        String userName = getFirstName.apply(new User
                (UUID.randomUUID(), "Charles", "Eimer"));

        System.out.println(userName);
        System.out.println();

        ///  Example 5: Conversion
        System.out.println("Example five: using Function < T, R > interface on the user object to convert the user object to a user id");
        UUID userId = getUserId.apply(new User
                (UUID.randomUUID(), "Charles", "Eimer"));

        System.out.println(userId);
        System.out.println();

    }

    static int incrementsNumberByOne(int number){ return number + 1; }

    static Function<Integer, Integer> incrementsNumberByOne = number -> number + 1;

    static Function<Integer, Integer> multiplyByTen = number -> number * 10;

    /**
     *      Chaining of Functions:
     *
     *      The process of combining multiple Function < T, R > instances into a single function (pipeline).
     *
     *      The Output (R) of the first function must match the Input (T) of the next.
     *
     *      Function< A, B > .andThen( Function < B, C > ) results in a Function < A, C >.
     *
     * */

    static Function<Integer, Integer> incrementsByOneAndMultiplyByTen = incrementsNumberByOne.andThen(multiplyByTen);

    static Function<User, String> getFirstName = User::getFirstName;

    static Function<User, UUID> getUserId = User::getUserId;

}
