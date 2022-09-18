package com.example.springdatajdbc.mapper;

import com.example.springdatajdbc.model.Human;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HumanRowMapper implements RowMapper<Human> {
    @Override
    public Human mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  Human.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .birth(LocalDate.parse(rs.getString("birth")))
                .build();
    }
}
