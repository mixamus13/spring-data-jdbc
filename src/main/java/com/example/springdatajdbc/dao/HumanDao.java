package com.example.springdatajdbc.dao;

import com.example.springdatajdbc.model.Human;

import java.util.List;
import java.util.Optional;

public interface HumanDao {

    List<Human> getAllHuman();

    Optional<Human> getHumanById(long id);

    void createHuman(Human human);

    void deleteHuman(int id);

    void updateHuman(Human human, long id);
}
