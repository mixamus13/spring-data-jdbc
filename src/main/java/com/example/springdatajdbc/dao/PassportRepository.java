package com.example.springdatajdbc.dao;

import com.example.springdatajdbc.mapper.PassportRowMapper;
import com.example.springdatajdbc.model.Passport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PassportRepository implements DAO<Passport> {

    private final NamedParameterJdbcOperations parameterJdbcOperations;

    @Override
    public List<Passport> getAll() {
        String sql = "select * from passport limit 100";

        List<Passport> passports = parameterJdbcOperations.query(
                sql,
                new PassportRowMapper());
        log.info("Get all passports: {}", passports);
        return passports;
    }

    @Override
    public Optional<Passport> getById(Integer id) {
        String sql = "select * from passport where id=:id";

        return Optional.ofNullable(Optional.ofNullable(parameterJdbcOperations.queryForObject(
                        sql,
                        Map.of("id", id),
                        new PassportRowMapper()))
                .orElseThrow(() -> new RuntimeException("Passport not found by id: " + id)));
    }

    @Override
    public void create(Passport passport) {
        String sql = "insert into passport(passport_number, first_name, last_name, age) values(:passport_number, :first_name, :last_name, :age)";
        int insert = parameterJdbcOperations.update(
                sql,
                Map.of(
                        "passport_number", passport.getPassportNumber(),
                        "first_name", passport.getFirstName(),
                        "last_name", passport.getLastName(),
                        "age", passport.getAge()));
        if (insert == 1) {
            log.info("Create new passport is id: {}", passport.getId());
        }
    }

    @Override
    public void update(Passport passport, Integer id) {
        String sql = "update passport set passport_number=:passport_number, first_name=:first_name, last_name=:last_name, age=:age where id=:id";
        int update = parameterJdbcOperations.update(
                sql,
                Map.of(
                        "id", id,
                        "passport_number", passport.getPassportNumber(),
                        "first_name", passport.getFirstName(),
                        "last_name", passport.getLastName(),
                        "age", passport.getAge()));
        if (update == 1) {
            log.info("Passport updated: {}", passport);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from passport where id=:id";
        parameterJdbcOperations.update(
                sql,
                Map.of("id", id));
    }
}

