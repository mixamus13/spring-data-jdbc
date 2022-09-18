package com.example.springdatajdbc.service;

import com.example.springdatajdbc.dao.HumanDao;
import com.example.springdatajdbc.model.Human;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanDao repository;

    public List<Human> getAllHuman() {
        return repository.getAllHuman();
    }

    public Optional<Human> getHumanById(long id) {
        return repository.getHumanById(id);
    }

    public void createHuman(Human human) {
        repository.createHuman(human);
    }

    public void deleteHuman(int id) {
        repository.deleteHuman(id);
    }

    public void updateHuman(Human human, long id) {
        repository.updateHuman(human, id);
    }
}
