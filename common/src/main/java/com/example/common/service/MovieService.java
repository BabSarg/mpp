package com.example.common.service;

import com.example.common.exception.UserNotFoundException;
import com.example.common.model.Movie;

import java.util.Date;
import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    void save(Movie movie);

    Movie findById(int id) throws UserNotFoundException;

    List<Movie> findByMultiCats(String name);


    List<Movie> findByYear(String year);

    List<Movie> findByActors(String actorName);

    List<Movie> findByRating(double rating);

    void deleteById(int id);



    List<Movie> addMovie(List<Integer> movies) throws UserNotFoundException;



    Object findMovieByTitle(String title);

    List<Movie> getAll();
}
