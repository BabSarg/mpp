package com.example.common.repository;

import com.example.common.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer> {

    List<Actor> findByName(String name);
    List<Actor> findByMovies(String movieName);
    List<Actor> findByCountry(String country);


}
