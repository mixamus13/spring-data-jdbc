package com.example.springdatajdbc.dao;

import com.example.springdatajdbc.mapper.PassportRowMapper;
import com.example.springdatajdbc.model.Passport;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PassportRepository implements PassportDao {

    private final NamedParameterJdbcOperations parameterJdbcOperations;

    @Override
    public List<Passport> getAllPassport() {
        String sql = "select * from passport limit 100";

        return parameterJdbcOperations.query(
                sql,
                new PassportRowMapper());
    }

    @Override
    public Passport getPassportById(Integer id) {
        String sql = "select * from passport where id=:id";

        return parameterJdbcOperations.queryForObject(
                sql,
                Map.of("id", id),
                new PassportRowMapper());
    }

    @Override
    public void createPassport(Passport passport) {
        String sql = "insert into passport(passport_number, first_name, last_name, age) values(:passport_number, :first_name, :last_name, :age)";

        parameterJdbcOperations.update(
                sql,
                Map.of(
                        "passport_number", passport.getPassportNumber(),
                        "first_name", passport.getFirstName(),
                        "last_name", passport.getLastName(),
                        "age", passport.getAge()));
    }

    @Override
    public void updatePassport(Passport passport, Integer id) {
        String sql = "update passport set passport_number=:passport_number, first_name=:first_name, last_name=:last_name, age=:age where id=:id";
        parameterJdbcOperations.update(
                sql,
                Map.of(
                        "id", id,
                        "passport_number", passport.getPassportNumber(),
                        "first_name", passport.getFirstName(),
                        "last_name", passport.getLastName(),
                        "age", passport.getAge()));
    }

    @Override
    public void deletePassport(Integer id) {
        String sql = "delete from passport where id=:id";
        parameterJdbcOperations.update(
                sql,
                Map.of("id", id));
    }
}
