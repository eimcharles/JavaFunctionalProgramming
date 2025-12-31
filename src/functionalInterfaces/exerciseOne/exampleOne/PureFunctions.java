package functionalInterfaces.exerciseOne.exampleOne;

public class PureFunctions {

    /**
     *          Pure functions
     *
     *          1. The function must have no state, cannot
     *          depend on a global variable outside of it.
     *
     *          2. The function must have no side effects, cannot
     *          change things outside of it:
     *
     *          - cannot print to the console
     *          - cannot update a database
     *          - treats inputs as read only
     *
     *          3. The function is deterministic
     *
     * */

    public static int sum(int a, int b) {
        return a + b;
    }

    public static String formatEmail(String username, String domain) {
        return username.toLowerCase() + "@" + domain.toLowerCase();
    }

}
