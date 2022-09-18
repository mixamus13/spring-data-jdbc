package com.example.springdatajdbc.mapper;

import com.example.springdatajdbc.model.Passport;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PassportRowMapper implements RowMapper<Passport> {
    @Override
    public Passport mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Passport.builder()
                .id(rs.getInt("id"))
                .passportNumber(rs.getInt("passport_number"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .age(rs.getInt("age"))
                .build();
    }
}
