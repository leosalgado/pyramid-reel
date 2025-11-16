package com.pyramidreel.api.model;

import com.pyramidreel.api.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class WatchedMovieItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime watchedAt;
    private int rating;
    private boolean rewatch;

    protected WatchedMovieItem() {
    }

    public WatchedMovieItem(User user, Movie movie) {
        this.movie = movie;
        this.watchedAt = LocalDateTime.now();
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getWatchedAt() {
        return watchedAt;
    }
}
