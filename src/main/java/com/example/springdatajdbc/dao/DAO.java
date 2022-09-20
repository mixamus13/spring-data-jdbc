package com.example.springdatajdbc.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> getAll();

    Optional<T> getById(Integer id);

    void create(T t);

    void update(T t, Integer id);

    void delete(Integer id);
}
