CREATE TABLE movie (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    release_date DATE,
    average_rating DOUBLE PRECISION
);

CREATE TABLE review (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    text VARCHAR(255) NOT NULL,
    rating INT NOT NULL,
    reviewed_at DATE,
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_review_movie FOREIGN KEY (movie_id) REFERENCES movie(id)
);

CREATE TABLE watched_movie_item (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    rating INT,
    watched_at TIMESTAMP,
    rewatch BOOLEAN,
    CONSTRAINT fk_watched_movie_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_watched_movie_movie FOREIGN KEY (movie_id) REFERENCES movie(id)
);

CREATE TABLE watchlist_item (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    date_added TIMESTAMP,
    CONSTRAINT fk_watchlist_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_watchlist_movie FOREIGN KEY (movie_id) REFERENCES movie(id)
);

CREATE TABLE user_friends (
    user_id BIGINT NOT NULL,
    friend_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, friend_id),
    CONSTRAINT fk_user_friend_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_friend_friend FOREIGN KEY (friend_id) REFERENCES users(id)
);
