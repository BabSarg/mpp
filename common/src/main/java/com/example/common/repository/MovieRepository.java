package com.example.common.repository;

import com.example.common.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface MovieRepository extends JpaRepository<Movie,Integer> {

     List<Movie> findByMultiCats(String  name);
     List<Movie> findByYear(String year);
     List<Movie> findByActors(String actorName);
     List<Movie> findByRating(double rating);
     Object findMovieByTitle(String title);


}
