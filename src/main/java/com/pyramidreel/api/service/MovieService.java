package com.pyramidreel.api.service;

import com.pyramidreel.api.model.Movie;

import java.util.List;

public interface MovieService {
    Movie getById(Long id);

    List<Movie> getAll();
}
