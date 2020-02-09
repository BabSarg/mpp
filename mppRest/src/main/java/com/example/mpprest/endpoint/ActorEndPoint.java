package com.example.mpprest.endpoint;


import com.example.common.model.Actor;
import com.example.common.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/actor")
public class ActorEndPoint {

    private final ActorService actorService;

    public ActorEndPoint(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findByMovie(@RequestParam("movie") String movieName){
        return actorService.findByMovies(movieName);
    }
    @GetMapping("/byCountry")
    public ResponseEntity findByCountry(@RequestParam("country") String countryName){
        return ResponseEntity.ok(actorService.findByCountry(countryName));
    }

}
