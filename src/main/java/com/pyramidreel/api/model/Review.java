package com.pyramidreel.api.model;

import com.pyramidreel.api.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public Review(User user, Movie movie, String text, int rating) {
        this.user = user;
        this.movie = movie;
        this.text = text;
        this.rating = rating;
        this.reviewedAt = LocalDate.now();
    }
}