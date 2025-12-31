package functionalInterfaces.exerciseTwo.exampleOne;

import domain.User;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;

public class ExampleOne {

    /**
     *      Declaring functions VS using Function < T, R > interface
     *
     *      Shifting from Method-based logic to Function-based logic.
     *
     *      T (Input): The type of the argument to the Function.
     *      R (Output): The type of the Output of the Function.
     *
     * */

    public static void main(String[] args) {

        ///  Example 1:
        System.out.println("Example one: declaring functions");
        System.out.println(incrementsNumberByOne(1));
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using Function < T, R > interface");
        System.out.println(incrementsNumberByOne.apply(1));
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: chaining Functions <T , R >");
        System.out.println(incrementsByOneAndMultiplyByTen.apply(1));
        System.out.println();

        ///  Example 4:
        System.out.println("Example four: using Function < T, R > interface on Lists");
        List<Integer> integerListIncremented = Stream.of(4,5,6,7,8)
                .map(ExampleOne::incrementsNumberByOne)
                .toList();

        System.out.println(integerListIncremented);
        System.out.println();

        ///  Example 5:
        System.out.println("Example five: using Function < T, R > interface on the User Class");
        String userName = getFirstName.apply(new User
                (UUID.randomUUID(), "Charles", "Eimer"));

        System.out.println(userName);

        UUID userId = getUserId.apply(new User
                (UUID.randomUUID(), "Charles", "Eimer"));

        System.out.println(userId);

    }

    static int incrementsNumberByOne(int number){ return number + 1; }

    static Function<Integer, Integer> incrementsNumberByOne = number -> number + 1;

    static Function<Integer, Integer> multiplyByTen = number -> number * 10;

    /**
     *      Chaining functions:
     *
     *      The process of combining multiple Function < T, R > instances into a single pipeline.
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
