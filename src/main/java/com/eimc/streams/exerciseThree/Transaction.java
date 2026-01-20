package com.eimc.streams.exerciseThree;

public record Transaction(

        int id,
        double amount,
        String type,
        String date,
        Customer customer

) { }
