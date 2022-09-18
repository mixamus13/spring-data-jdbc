package com.example.springdatajdbc.dao;

import com.example.springdatajdbc.model.Passport;

import java.util.List;

public interface PassportDao {

    List<Passport> getAllPassport();

    Passport getPassportById(Integer id);

    void createPassport(Passport passport);

    void updatePassport(Passport passport, Integer id);

    void deletePassport(Integer id);
}
