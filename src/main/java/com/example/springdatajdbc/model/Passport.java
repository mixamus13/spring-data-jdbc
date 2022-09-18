package com.example.springdatajdbc.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
@Builder
public class Passport {
    @Id
    Integer id;
    Integer passportNumber;
    String firstName;
    String lastName;
    Integer age;
}
