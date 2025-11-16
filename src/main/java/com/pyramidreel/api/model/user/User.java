package com.pyramidreel.api.model.user;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Review> reviews;
//
//    @ManyToMany
//    private List<User> friends;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<WatchedMovieItem> watchedMovies;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<WatchlistItem> watchlist;

    protected User() {
    }

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

//    public void addToWatchlist(Movie movie) {
//        boolean alreadyInWatchlist = watchlist.stream().anyMatch(item -> item.getMovie().equals(movie));
//        boolean alreadyWatched = watchedMovies.stream().anyMatch(item -> item.getMovie().equals(movie));
//
//        if (!alreadyInWatchlist && !alreadyWatched) {
//            watchlist.add(new WatchlistItem(this, movie));
//        }
//
//    }
//
//    public void markAsWatched(Movie movie) {
//        watchlist.removeIf(item -> item.getMovie().equals(movie));
//
//        watchedMovies.add(new WatchedMovieItem(this, movie));
//    }
//
//    public void addReview(Movie movie, String text, int rating) {
//        reviews.add(new Review(this, movie, text, rating));
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_PRO"), new SimpleGrantedAuthority("ROLE_USER"));
        } else if (this.role == UserRole.PRO) {
            return List.of(new SimpleGrantedAuthority("ROLE_PRO"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//
//    public List<User> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(List<User> friends) {
//        this.friends = friends;
//    }
//
//    public List<WatchedMovieItem> getWatchedMovies() {
//        return watchedMovies;
//    }
//
//    public List<WatchlistItem> getWatchlist() {
//        return watchlist;
//    }
}
