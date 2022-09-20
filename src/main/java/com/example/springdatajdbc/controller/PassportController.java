package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.model.Passport;
import com.example.springdatajdbc.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PassportController {

    private final PassportService passportService;

    @GetMapping("/api/passport/all")
    public List<Passport> getAllPassport() {
        return passportService.getAllPassport();
    }

    @GetMapping("/api/passport/byId/{id}")
    public Optional<Passport> getPassportById(@PathVariable("id") Integer id) {
        return passportService.getPassportById(id);
    }

    @PostMapping("/api/passport/create")
    public void createPassport(@RequestBody Passport passport) {
        passportService.createPassport(passport);
    }

    @DeleteMapping("/api/passport/delete/{id}")
    public void deletePassport(@PathVariable("id") Integer id) {
        passportService.deletePassport(id);
    }

    @PutMapping("/api/passport/update/{id}")
    public void updatePassport(@RequestBody Passport passport, @PathVariable("id") Integer id) {
        passportService.updatePassport(passport, id);
    }
}
