package com.pyramidreel.api.model;

import com.pyramidreel.api.model.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class DiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToOne(mappedBy = "diaryEntry", cascade = CascadeType.ALL)
    private Review review;

    private LocalDateTime watchedAt;
    private Integer rating;
    private boolean rewatch;

    protected DiaryEntry() {
    }

    public DiaryEntry(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
        this.watchedAt = LocalDateTime.now();
    }

    public void addReview(String text) {
        this.review = new Review(this, text);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public LocalDateTime getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(LocalDateTime watchedAt) {
        this.watchedAt = watchedAt;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean isRewatch() {
        return rewatch;
    }

    public void setRewatch(boolean rewatch) {
        this.rewatch = rewatch;
    }
}