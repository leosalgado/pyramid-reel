package com.pyramidreel.api.model.user;


import com.pyramidreel.api.model.Movie;
import com.pyramidreel.api.model.Review;
import com.pyramidreel.api.model.WatchedMovieItem;
import com.pyramidreel.api.model.WatchlistItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_friends", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<User> friends;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<WatchedMovieItem> watchedMovies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<WatchlistItem> watchlist;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void addToWatchlist(Movie movie) {
        boolean alreadyInWatchlist = watchlist.stream().anyMatch(item -> item.getMovie().equals(movie));
        boolean alreadyWatched = watchedMovies.stream().anyMatch(item -> item.getMovie().equals(movie));

        if (!alreadyInWatchlist && !alreadyWatched) {
            watchlist.add(new WatchlistItem(this, movie));
        }

    }

    public void markAsWatched(Movie movie) {
        watchlist.removeIf(item -> item.getMovie().equals(movie));

        watchedMovies.add(new WatchedMovieItem(this, movie));
    }

    public void addReview(Movie movie, String text, int rating) {
        reviews.add(new Review(this, movie, text, rating));
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
}
