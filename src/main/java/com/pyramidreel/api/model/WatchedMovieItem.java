package com.pyramidreel.api.model;

import com.pyramidreel.api.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public WatchedMovieItem(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
        this.watchedAt = LocalDateTime.now();
    }
}