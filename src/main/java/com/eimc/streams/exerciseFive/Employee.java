package com.eimc.streams.exerciseFive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Employee (

        UUID id,
        String name,
        String email,
        String phoneNumber,
        BigDecimal salary,
        String city,
        String gender,
        LocalDateTime dateOfBirth,
        String department,
        int age

) {

}

