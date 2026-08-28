package com.pyramidreel.api.service.impl;

import com.pyramidreel.api.model.Movie;
import com.pyramidreel.api.repository.MovieRepository;
import com.pyramidreel.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie getById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
