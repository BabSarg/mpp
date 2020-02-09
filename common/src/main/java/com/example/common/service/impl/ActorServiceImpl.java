package com.example.common.service.impl;

import com.example.common.model.Actor;
import com.example.common.repository.ActorRepository;
import com.example.common.service.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public boolean isExists(int id) {
        return actorRepository.findById(id).isPresent();
    }

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    public Optional<Actor> findById(int id) {
        return actorRepository.findById(id);
    }

    public List<Actor> findByName(String name) {
        return actorRepository.findByName(name);
    }

    @Override
    public List<Actor> findByMovies(String movieName) {
        return actorRepository.findByMovies(movieName);
    }

    public List<Actor> findByCountry(String country) {
        return actorRepository.findByCountry(country);
    }

    @Override
    public void deleteById(int id) {
        actorRepository.deleteById(id);
    }

}

