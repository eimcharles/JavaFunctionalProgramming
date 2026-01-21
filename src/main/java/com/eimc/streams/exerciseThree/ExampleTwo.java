package com.eimc.streams.exerciseThree;

import java.util.*;
import java.util.stream.Collectors;

import static com.eimc.streams.exerciseThree.Transaction.populateTransactions;

public class ExampleTwo {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();
        populateTransactions(transactions);

        ///  Example 1:
        System.out.println("Example one: calculating the average transaction amount from the transaction list");
        OptionalDouble averageTransaction = transactions
                .stream()
                .mapToDouble(Transaction::amount)
                .average();

        averageTransaction
                .ifPresentOrElse( amount -> System.out.println("Average transaction amount: " + amount + "$"),
                        () -> System.out.println("No transactions present"));

        System.out.println();

        ///  Example 2:
        System.out.println("Example two: retrieving all transactions made by a specific customer (e.g., Customer9)");
        transactions.stream().
                filter(transaction
                        -> transaction.customer().name().equals("Customer9"))
                .forEach(System.out::println);

        System.out.println();

        ///  Example 3:
        System.out.println("Example three: retrieving a list of distinct transactions");
        transactions.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        ///  Example 4:
        System.out.println("Example four: retrieving the most recent transaction by date");
        Optional<Transaction> mostRecentTransactionsByDate = transactions.stream()
                .max(Comparator.comparing(Transaction::date));

        mostRecentTransactionsByDate
                .ifPresentOrElse(transaction
                                -> System.out.println("Most recent transaction by date: " + transaction.date()),
                () -> System.out.println("No transactions present"));

        System.out.println();

        ///  Example 5:
        System.out.println("Example five: calculating the total transaction amount by customer.");
        Map<Customer, Double> totalPerCustomer = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::customer, Collectors.summingDouble(Transaction::amount)));

        totalPerCustomer.forEach( ((customer, aDouble) ->
            System.out.println(customer.name() + " total amount: " + aDouble)));

        System.out.println();

        ///  Example 6:
        System.out.println("Example six: grouping transactions by DEBIT and CREDIT");
        Map<String, List<Transaction>> typeOfTransaction = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::type));

        typeOfTransaction.forEach((type , transaction) ->

                {
                    System.out.println("Type: " + type);
                    transaction.forEach(t ->
                            System.out.println("Transaction id: " + t.id() + ", type " + t.type()));
                });

        System.out.println();

        ///  Example 7:
        System.out.println("Example seven: retrieving all transactions made by customers with an email containing customer99@example.com");
        transactions.stream().
                filter(transaction
                        -> transaction.customer().email().contains("customer99"))
                .forEach(System.out::println);

        System.out.println();

    }
}
