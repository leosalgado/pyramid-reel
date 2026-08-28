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

    public DiaryEntry(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
        this.watchedAt = LocalDateTime.now();
    }

    public void addReview(String text) {
        this.review = new Review(this, text);
    }
}