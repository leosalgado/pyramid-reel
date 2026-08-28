ALTER TABLE movie ADD COLUMN details JSONB;
CREATE INDEX idx_movie_details ON movie USING GIN (details);