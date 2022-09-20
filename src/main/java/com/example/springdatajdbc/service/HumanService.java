package com.example.springdatajdbc.service;

import com.example.springdatajdbc.dao.DAO;
import com.example.springdatajdbc.model.Human;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final DAO<Human> repository;

    public List<Human> getAllHuman() {
        return repository.getAll();
    }

    public Optional<Human> getHumanById(Integer id) {
        return repository.getById(id);
    }

    public void createHuman(Human human) {
        repository.create(human);
    }

    public void deleteHuman(int id) {
        repository.delete(id);
    }

    public void updateHuman(Human human, Integer id) {
        repository.update(human, id);
    }
}
