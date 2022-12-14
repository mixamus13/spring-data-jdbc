package com.example.springdatajdbc.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;


@Value
@Builder
public class Human {
    @Id
    Long id;
    String name;
    String email;
    LocalDate birth;
}
