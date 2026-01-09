package com.eimc.functionalInterfaces.pureAndImpureFunctions;

public class ImpureFunctions {

    /**
     *      Impure functions
     *
     *      1. The function has state or dependencies, it
     *      reaches outside to read global variables.
     *
     *      2. The function has side effects, it
     *         changes elements outside of it:
     *
     *      - modifies the console
     *      - updates a database or file system
     *      - mutates the input objects directly
     *
     *      3. The function is non-deterministic (random or time-based)
     *
     * */

    // IMPURE: Depends on 'multiplier' (Shared State)
    static int emailCount = 0;

    // IMPURE: Modifies global variable (Side Effect)
    static int multiplier = 1;

    public static int sum(int a, int b) {
        return (a + b) * multiplier;
    }

    public static String formatEmail(String username, String domain) {
        emailCount++;
        return username.toLowerCase() + "@" + domain.toLowerCase();
    }

}
