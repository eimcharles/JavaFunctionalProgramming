package com.eimc.streams.exerciseThree;

import java.util.*;
import java.util.stream.Collectors;

import static com.eimc.streams.exerciseThree.Transaction.populateTransactions;

public class ExampleOne {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();
        populateTransactions(transactions);

        ///  Example 1:
        System.out.println("Example one: retrieving all transactions by type CREDIT");
        transactions.stream()
                .filter(transaction ->
                        transaction.type().equals("CREDIT"))
                .forEach(transaction
                        -> System.out.println("Transaction id: " + transaction.id()
                        + ", type: " + transaction.type()));

        System.out.println();

        ///  Example 2:
        System.out.println("Example two: calculate the total sum of all transactions");
        double totalSumOfTransactions = transactions.stream()
                .mapToDouble(Transaction::amount)
                        .sum();

        System.out.println("Total sum of all transactions: " + totalSumOfTransactions + "$");
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: finding the maximum transaction amount in transaction list");
        OptionalDouble maxTransactionAmount = transactions.stream().
                mapToDouble(Transaction::amount)
                .max();

        maxTransactionAmount.ifPresent(amount ->
                System.out.println("Maximum transaction amount: " + amount + "$" )
        );
        System.out.println();

        ///  Example 4:
        System.out.println("Example four: counting the amount of transactions by type CREDIT / DEBIT");
        Map<String, Long> transactionTypeCount = transactions.stream()
                ///  Grouping by type and count
                .collect(Collectors.groupingBy(Transaction::type, Collectors.counting()));

        transactionTypeCount.forEach( (type, count) ->

                {
                    System.out.println("Type: " + type);
                    System.out.println("Count: " + count);
                });

        System.out.println();

        ///  Example 5:
        System.out.println("Example five: retrieving a list of distinct customers id's and emails from all transactions");
        transactions.stream().
                map(Transaction::customer)
                .distinct()
                .forEach(customer
                        -> System.out.println("Customer id: " + customer.id() + ", email " + customer.email() ));

        System.out.println();

        ///  Example 6:
        System.out.println("Example six: retrieving all transactions strictly greater than 300$");
        transactions.stream()
                ///  All transactions greater than 300$
                .filter(transaction -> transaction.amount() > 300)
                ///  Sort them by from lowest to highest
                .sorted(Comparator.comparingDouble(Transaction::amount))
                .forEach(transaction
                        -> System.out.println("Transaction id: " + transaction.id()
                        + ", amount " + transaction.amount() + "$"));

        System.out.println();

        ///  Example 7:
        System.out.println("Example seven: grouping transactions by customer id and transaction id");
        Map<Customer, List<Transaction>> TransactionsByCustomer = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::customer));

        TransactionsByCustomer
                .forEach(((customer, transactionList) ->

                {

                    System.out.println(customer.name());

                    transactionList.forEach( transaction
                            -> System.out.println("Transaction id: " + transaction.id()));

                    System.out.println();

                }));

        ///  Example 8:
        System.out.println("Example eight: finding the first transaction in the transaction list");
        Optional<Transaction> firstTransactionOptional = transactions.stream()
                .findFirst();

        firstTransactionOptional
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No transactions present"));

        System.out.println();

        ///  Example 9:
        System.out.println("Example nine: checking if there is a transaction greater than 1000$ present in the transaction list");
        boolean containsHighValue = transactions.stream()
                .anyMatch(transaction -> transaction.amount() > 1000);

        System.out.println("The transaction list contains a transaction greater than 1000$: " + containsHighValue);
        System.out.println();

        ///  Example 10:
        System.out.println("Example ten: sorting transactions in ascending order by amount");
        transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::amount))
                .forEach(transaction
                        -> System.out.println("Transaction id: " + transaction.id()
                        + ", amount " + transaction.amount() + "$"));

        System.out.println();

    }

}
