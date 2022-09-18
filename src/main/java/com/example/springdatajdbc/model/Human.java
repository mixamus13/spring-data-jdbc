package com.example.springdatajdbc.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table
@Data
@Builder
public class Human {
    @Id
    private final Long id;
    private final String name;
    private final String email;
    private final LocalDate birth;
}
