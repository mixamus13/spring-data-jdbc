package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.model.Passport;
import com.example.springdatajdbc.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PassportController {

    private final PassportService passportService;

    @GetMapping("/api/allPassport")
    public List<Passport> getAllPassport() {
        return passportService.getAllPassport();
    }

    @GetMapping("/api/passportById/{id}")
    public Passport getPassportById(@PathVariable("id") Integer id) {
        return passportService.getPassportById(id);
    }

    @PostMapping("/api/createPassport")
    public void createPassport(@RequestBody Passport passport) {
        passportService.createPassport(passport);
    }

    @DeleteMapping("/api/deletePassport/{id}")
    public void deletePassport(@PathVariable("id") Integer id) {
        passportService.deletePassport(id);
    }

    @PutMapping("/api/updatePassport/{id}")
    public void updatePassport(@RequestBody Passport passport, @PathVariable("id") Integer id) {
        passportService.updatePassport(passport, id);
    }
}
