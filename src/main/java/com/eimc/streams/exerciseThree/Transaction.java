package com.eimc.streams.exerciseThree;

import java.util.List;

public record Transaction(

        int id,
        double amount,
        String type,
        String date,
        Customer customer

) {

    public static void populateTransactions(List<Transaction> transactionList){

        for (int index = 1; index <= 100; index++) {

            transactionList.add(

                    new Transaction(
                            index,
                            Math.random() * 1000, index % 2 == 0 ? "CREDIT" : "DEBIT",
                            "2024-" + String.format("%02d", (index % 12) + 1) +
                                    "-" + String.format("%02d", (index % 28) + 1),

                            new Customer(index, "Customer" + index, "customer" + index + "@example.com"))
            );

        }
    }

}
