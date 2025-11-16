package com.pyramidreel.api.model;

import com.pyramidreel.api.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class WatchlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime dateAdded;

    protected WatchlistItem() {
    }

    public WatchlistItem(User user, Movie movie) {
        this.movie = movie;
        this.dateAdded = LocalDateTime.now();
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
}
