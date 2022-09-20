package com.example.springdatajdbc.service;

import com.example.springdatajdbc.dao.DAO;
import com.example.springdatajdbc.model.Passport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassportService {

    private final DAO<Passport> passportDao;

    public List<Passport> getAllPassport() {
        return passportDao.getAll();
    }

    public Optional<Passport> getPassportById(Integer id) {
        return passportDao.getById(id);
    }

    public void createPassport(Passport passport) {
        passportDao.create(passport);
    }

    public void deletePassport(Integer id) {
        passportDao.delete(id);
    }

    public void updatePassport(Passport passport, Integer id) {
        passportDao.update(passport, id);
    }
}
