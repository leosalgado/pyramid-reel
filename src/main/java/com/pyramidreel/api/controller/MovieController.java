package com.pyramidreel.api.controller;

import com.pyramidreel.api.model.Movie;
import com.pyramidreel.api.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @GetMapping
    public List<Movie> findAllMovies() {
        return movieService.getAll();
    }
}
