package com.pyramidreel.api.model;

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

    @OneToOne
    @JoinColumn(name = "diary_entry_id")
    private DiaryEntry diaryEntry;

    private String review;

    public Review(DiaryEntry diaryEntry, String review) {
        this.diaryEntry = diaryEntry;
        this.review = review;
    }
}