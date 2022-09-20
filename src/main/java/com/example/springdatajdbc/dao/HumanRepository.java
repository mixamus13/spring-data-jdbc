package com.example.springdatajdbc.dao;

import com.example.springdatajdbc.mapper.HumanRowMapper;
import com.example.springdatajdbc.model.Human;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HumanRepository implements DAO<Human> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Human> getAll() {
        String sql = "select id, name, email, birth from human limit 100";
        return jdbcTemplate.query(sql,
                new HumanRowMapper());
    }

    @Override
    public Optional<Human> getById(Integer id) {
        String sql = "select id, name, email, birth from human where id = ?";
        return jdbcTemplate.query(sql,
                        new HumanRowMapper(),
                        id)
                .stream()
                .findFirst();
    }

    @Override
    public void create(Human human) {
        String sql = "insert into human(name, email, birth) values(?, ?, ?)";
        jdbcTemplate.update(sql,
                human.getName(), human.getEmail(), human.getBirth());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from human where id = ?";
        jdbcTemplate.update(sql,
                id);
    }

    @Override
    public void update(Human human, Integer id) {
        String sql = "update human set name = ?, email = ?, birth = ? where id = ?";
        jdbcTemplate.update(sql,
                human.getName(),
                human.getEmail(),
                human.getBirth(),
                id);
    }
}
