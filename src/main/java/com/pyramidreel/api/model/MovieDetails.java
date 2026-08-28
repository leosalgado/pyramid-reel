package com.pyramidreel.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDetails {
    private List<String> genres;
    private int duration;
    private List<String> directors;
    private List<String> cast;
}
