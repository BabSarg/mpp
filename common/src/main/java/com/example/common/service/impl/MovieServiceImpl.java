package com.example.common.service.impl;


import com.example.common.exception.UserNotFoundException;
import com.example.common.model.Movie;
import com.example.common.repository.MovieRepository;
import com.example.common.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie findById(int id) throws UserNotFoundException {
        return movieRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public List<Movie> findByMultiCats(String name) {
        return movieRepository.findByMultiCats(name);
    }




    public List<Movie> findByYear(String year){
        return movieRepository.findByYear(year);
    }

 public List<Movie> findByActors(String actorName){
     return movieRepository.findByActors(actorName);
    }

    public List<Movie> findByRating(double rating){
        return movieRepository.findByRating(rating);
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }



    @Override
    public List<Movie> addMovie(List<Integer> movies) throws UserNotFoundException {

        List<Movie> movieList = new ArrayList<>();
        for (Integer movie : movies) {
            Movie byId = findById(movie);
            movieList.add(byId);
        }
        return movieList;
    }



    @Override
    public Object findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }


}
