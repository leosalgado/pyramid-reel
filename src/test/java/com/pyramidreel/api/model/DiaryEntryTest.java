package com.pyramidreel.api.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class DiaryEntryTest {

    @Test
    void addReview_shouldSetBidirectionalReference() {
        DiaryEntry entry = new DiaryEntry();

        entry.addReview("show");

        Assertions.assertThat(entry.getReview()).isNotNull();
        Assertions.assertThat(entry.getReview().getReview()).isEqualTo("show");
        Assertions.assertThat(entry.getReview().getDiaryEntry()).isEqualTo(entry);
    }
}
