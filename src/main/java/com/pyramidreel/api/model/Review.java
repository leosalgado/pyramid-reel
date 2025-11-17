package com.pyramidreel.api.model;

import com.pyramidreel.api.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String text;
    private int rating;
    private LocalDate reviewedAt;

    protected Review() {
    }

    public Review(User user, Movie movie, String text, int rating) {
        this.user = user;
        this.movie = movie;
        this.text = text;
        this.rating = rating;
        this.reviewedAt = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getReviewedAt() {
        return reviewedAt;
    }
}
