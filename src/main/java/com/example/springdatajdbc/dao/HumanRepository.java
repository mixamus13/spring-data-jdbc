package com.example.springdatajdbc.dao;

import com.example.springdatajdbc.mapper.HumanRowMapper;
import com.example.springdatajdbc.model.Human;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class HumanRepository implements DAO<Human> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Human> getAll() {
        String sql = "select id, name, email, birth from human limit 100";
        List<Human> humans = jdbcTemplate.query(sql,
                new HumanRowMapper());
        log.info("Get all humans: {}", humans);
        return humans;
    }

    @Override
    public Optional<Human> getById(Integer id) {
        String sql = "select id, name, email, birth from human where id = ?";
        return jdbcTemplate.query(sql,
                        new HumanRowMapper(),
                        id)
                .stream()
                .filter(Objects::nonNull)
                .findFirst();
    }

    @Override
    public void create(Human human) {
        String sql = "insert into human(name, email, birth) values(?, ?, ?)";
        int insert = jdbcTemplate.update(sql,
                human.getName(), human.getEmail(), human.getBirth());
        if (insert == 1) {
            log.info("Create new human is id: {}", human.getId());
        }
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
        int update = jdbcTemplate.update(sql,
                human.getName(),
                human.getEmail(),
                human.getBirth(),
                id);
        if (update == 1) {
            log.info("Human updated: {}", human);
        }
    }
}
