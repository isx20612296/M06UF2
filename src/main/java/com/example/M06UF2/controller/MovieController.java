package com.example.M06UF2.controller;

import com.example.M06UF2.domain.Movie;
import com.example.M06UF2.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieRepository movieRepository;

    MovieController(com.example.M06UF2.repository.MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public List<Movie> talicual() {
        return movieRepository.findAll();
    }
}
