package com.pyramidreel.api.model;

import java.util.List;

public class User {

    private Long id;
    private String username;
    private final String password;

    private List<Review> reviews;
    private List<User> friends;
    private List<Movie> watchedMovies;
    private List<Movie> watchlist;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addToWatchlist(Movie movie) {
        if (!watchlist.contains(movie)) {
            watchlist.add(movie);
        }
    }

    public void markAsWatched(Movie movie) {
        if (!watchedMovies.contains(movie)) {
            watchedMovies.add(movie);
            watchlist.remove(movie);
        }
    }

    public void addReview(Movie movie, String text, int rating) {
        reviews.add(new Review(this, movie, text, rating));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public List<Movie> getWatchlist() {
        return watchlist;
    }
}
