-- users
ALTER TABLE users ALTER COLUMN id TYPE BIGINT;
ALTER TABLE users ALTER COLUMN username TYPE VARCHAR(50);
ALTER TABLE users ALTER COLUMN password TYPE VARCHAR(255);
ALTER TABLE users ALTER COLUMN role TYPE VARCHAR(5);

--movie
ALTER TABLE movie ALTER COLUMN id TYPE BIGINT;

-- watched_movie_item -> diary_entry
ALTER TABLE watched_movie_item RENAME TO diary_entry;
ALTER TABLE diary_entry ALTER COLUMN id TYPE BIGINT;
ALTER TABLE diary_entry ALTER COLUMN user_id TYPE BIGINT;
ALTER TABLE diary_entry ALTER COLUMN movie_id TYPE BIGINT;

-- review
ALTER TABLE review ALTER COLUMN id TYPE BIGINT;
ALTER TABLE review RENAME COLUMN text TO review;
ALTER TABLE review DROP COLUMN user_id;
ALTER TABLE review DROP COLUMN movie_id;
ALTER TABLE review DROP COLUMN rating;
ALTER TABLE review DROP COLUMN reviewed_at;
ALTER TABLE review ALTER COLUMN review DROP NOT NULL;
ALTER TABLE review ADD COLUMN diary_entry_id BIGINT;
ALTER TABLE review ADD CONSTRAINT fk_diary_entry FOREIGN KEY (diary_entry_id) REFERENCES diary_entry(id);
ALTER TABLE review ADD CONSTRAINT uq_diary_entry UNIQUE (diary_entry_id);

-- watchlist_item
ALTER TABLE watchlist_item ALTER COLUMN id TYPE BIGINT;
ALTER TABLE watchlist_item ALTER COLUMN user_id TYPE BIGINT;
ALTER TABLE watchlist_item ALTER COLUMN movie_id TYPE BIGINT;
ALTER TABLE watchlist_item ALTER COLUMN date_added TYPE DATE;

-- user_friends -> follows
ALTER TABLE user_friends RENAME TO follows;
ALTER TABLE follows RENAME COLUMN user_id TO follower_id;
ALTER TABLE follows RENAME COLUMN friend_id TO followed_id;
ALTER TABLE follows ALTER COLUMN follower_id TYPE BIGINT;
ALTER TABLE follows ALTER COLUMN followed_id TYPE BIGINT;
ALTER TABLE follows DROP CONSTRAINT user_friends_pkey;
ALTER TABLE follows ADD PRIMARY KEY (follower_id,followed_id);
ALTER TABLE follows ADD COLUMN created_at TIMESTAMP;