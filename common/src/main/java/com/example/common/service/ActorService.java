package com.example.common.service;

import com.example.common.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    boolean isExists(int id);
    List<Actor> findAll();
    Optional<Actor> findById(int id);
    List<Actor> findByName(String name);
    List<Actor> findByMovies(String movieName);
    List<Actor> findByCountry(String country);
    void deleteById(int id);
}
