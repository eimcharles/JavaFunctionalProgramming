package com.eimc.functionalInterfaces.combinatorPattern;


import com.eimc.domain.User;

import java.util.function.Predicate;

/**
 *     UserValidator is a general domain-specific
 *     Functional Interface which uses the Combinator Pattern:
 *
 *       - It allows to build complex validation chains
 *       and defines the shape of a valid user.
 *
 *     Transforms a generic Predicate <T> Functional Interface
 *     into a UserValidator business contract.
 */

@FunctionalInterface
public interface UserValidator extends Predicate<User> {

    /**
     *      Overridden to allow multiple UserValidator
     *      instances to be chained together into a
     *      single pipeline.
     *
     *      Enables the "Builder" syntax instead of
     *      nested-if statements
     */

    default UserValidator and(UserValidator nextRule) {
        return user -> this.test(user) && nextRule.test(user);
    }

    /**
     *     Static methods are different business rule definitions
     *
     *     Represent the "source of truth" for what
     *     constitutes a valid User.
     *
     *     They server as the starting point for
     *     building the validation chain.
     */

    static UserValidator hasValidFirstName() {
        ///  Lambda mapped to test() at runtime
        return user -> user.getFirstName() != null && !user.getFirstName().isBlank();
    }

    static UserValidator hasValidLastName() {
        ///  Lambda mapped to test() at runtime
        return user -> user.getLastName() != null && !user.getLastName().isBlank();
    }

    static UserValidator hasValidId() {
        ///  Lambda mapped to test() at runtime
        return user -> user.getUserId() != null;
    }

}
