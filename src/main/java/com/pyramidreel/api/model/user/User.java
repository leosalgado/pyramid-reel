package com.pyramidreel.api.model.user;


import com.pyramidreel.api.model.DiaryEntry;
import com.pyramidreel.api.model.WatchlistItem;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
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

    @ManyToMany
    @JoinTable(
            name = "follows",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "followed_id")
    )
    private List<User> following = new ArrayList<>();

    @ManyToMany(mappedBy = "following")
    private List<User> followers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<DiaryEntry> watchedMovies;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<WatchlistItem> watchlist;

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

//    public void markAsWatched(Movie movie) {
//        watchlist.removeIf(item -> item.getMovie().equals(movie));
//
//        watchedMovies.add(new DiaryEntry(this, movie));
//    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<DiaryEntry> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(List<DiaryEntry> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public List<WatchlistItem> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(List<WatchlistItem> watchlist) {
        this.watchlist = watchlist;
    }
}
