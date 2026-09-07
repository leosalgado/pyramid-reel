package com.pyramidreel.api.service;

import com.pyramidreel.api.model.Movie;
import com.pyramidreel.api.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
