package com.example.mpprest.endpoint;


import com.example.common.exception.UserNotFoundException;
import com.example.common.model.Movie;
import com.example.common.service.CategoryService;
import com.example.common.service.MovieService;
import com.example.common.service.MultiCatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/movies")
public class MovieEndPoint {

    private final MovieService movieService;


    public MovieEndPoint(MovieService movieService, CategoryService categoryService, MultiCatService multiCatService) {
        this.movieService = movieService;
    }


    @GetMapping
    public List<Movie> getAll(){
    return movieService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") int id) throws UserNotFoundException {
        return ResponseEntity.ok(movieService.findById(id));
    }
    @GetMapping("/findByMultiCat")
    public List<Movie> findByMultiCat(@RequestParam("multiCatName") String multiCatName)  {
        return movieService.findByMultiCats(multiCatName);
    }

    @GetMapping("/findByName")
    public ResponseEntity findMovieByTitle(@RequestParam("MovieName") String title) {
        return ResponseEntity.ok(movieService.findMovieByTitle(title));
    }

    @GetMapping("/findByYear")
    public List<Movie> findByYear(@RequestParam("year") Date year)  {
        return movieService.findByYear(year);
    }

    @GetMapping("/findByActor")
    public List<Movie> findByActor(@RequestParam("actor") String actorName) {
        return movieService.findByActors(actorName);
    }

    @GetMapping("/findByRating")
    public ResponseEntity findByRating(@RequestParam("rating") double rating) {
        return ResponseEntity.ok(movieService.findByRating(rating));
    }
}
