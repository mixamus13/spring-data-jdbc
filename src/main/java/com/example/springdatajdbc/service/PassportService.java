package com.example.springdatajdbc.service;

import com.example.springdatajdbc.dao.PassportDao;
import com.example.springdatajdbc.model.Passport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportService {

    private final PassportDao passportDao;

    public List<Passport> getAllPassport() {
        return passportDao.getAllPassport();
    }

    public Passport getPassportById(Integer id) {
        return passportDao.getPassportById(id);
    }

    public void createPassport(Passport passport) {
        passportDao.createPassport(passport);
    }

    public void deletePassport(Integer id) {
        passportDao.deletePassport(id);
    }

    public void updatePassport(Passport passport, Integer id) {
        passportDao.updatePassport(passport, id);
    }
}
