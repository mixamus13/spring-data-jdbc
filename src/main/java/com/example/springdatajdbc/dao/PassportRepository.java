package com.example.springdatajdbc.dao;

import com.example.springdatajdbc.mapper.PassportRowMapper;
import com.example.springdatajdbc.model.Passport;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.example.springdatajdbc.mapper.PassportRowMapper.createNewPassport;

@Repository
@RequiredArgsConstructor
public class PassportRepository implements PassportDao {

    private final NamedParameterJdbcOperations parameterJdbcOperations;

    @Override
    public List<Passport> getAllPassport() {
        String sql = "select id, name, email, birth from human limit 100";

        return parameterJdbcOperations.query(sql,
                new PassportRowMapper());
    }

    @Override
    public Passport getPassportById(Integer id) {
        String sql = "select id, name, email, birth from human where id =:id";

        return parameterJdbcOperations.queryForObject(sql,
                Map.of("id", id),
                new PassportRowMapper());
    }

    @Override
    public void createPassport(Passport passport) {
        String sql = "insert into passport(passport_number, first_name, last_name, age) " +
                "values(:passport_number, :first_name, :last_name, :age)";

        parameterJdbcOperations.update(sql,
                createNewPassport(passport));
    }

    @Override
    public void updatePassport(Passport passport, Integer id) {

    }

    @Override
    public void deletePassport(Integer id) {

    }
}
