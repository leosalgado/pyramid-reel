ALTER TABLE watchlist_item RENAME COLUMN date_added TO added_at;

UPDATE watchlist_item SET added_at = CURRENT_TIMESTAMP WHERE added_at IS NULL;

ALTER TABLE watchlist_item ALTER COLUMN added_at TYPE TIMESTAMP;
ALTER TABLE watchlist_item ALTER COLUMN added_at SET NOT NULL;
ALTER TABLE watchlist_item ALTER COLUMN added_at SET DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE watchlist_item ADD CONSTRAINT uq_watchlist_user_movie UNIQUE (user_id, movie_id);