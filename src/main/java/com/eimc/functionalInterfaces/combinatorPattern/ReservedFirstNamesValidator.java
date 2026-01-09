package com.eimc.functionalInterfaces.combinatorPattern;


import com.eimc.domain.User;

import java.util.List;

/**
 *      ReservedFirstNamesValidator is a specific implementation
 *      of the UserValidator business contract:
 *
 *      Concrete implementation of UserValidator
 *      that prevents users from registering with
 *      system-reserved first name.
 */

public class ReservedFirstNamesValidator implements UserValidator {

    private final List<String> reservedFirstNames = List.of("Admin", "Support");


    /**
     *      Concrete implementation of abstract test()
     *      method inherited from Predicate < T > class.
     *
     *      Prevents users from registering with
     *      system-reserved first names.
     *
     * */

    @Override
    public boolean test(User user) {
        return reservedFirstNames.stream()
                .noneMatch(reserved -> reserved.equalsIgnoreCase(user.getFirstName()));
    }

}
