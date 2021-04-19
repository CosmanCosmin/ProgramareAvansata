DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS movie_director;
DROP TABLE IF EXISTS movie_actor;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS directors;
DROP TABLE IF EXISTS actors;

CREATE TABLE movies(
    id VARCHAR(10) PRIMARY KEY,
    title VARCHAR(30),
    release_year int,
    release_date VARCHAR(30),
    duration INT,
    language VARCHAR(30),
    score DECIMAL
     );

CREATE TABLE genres(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE directors(
    id SERIAL PRIMARY KEY,
    name varchar(50)
);

CREATE TABLE actors(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE movie_genre(
    movieID VARCHAR(10) REFERENCES movies(id),
    genreID SERIAL REFERENCES genres(id)
);

CREATE TABLE movie_director(
    movieID VARCHAR(10) REFERENCES movies(id),
    directorID SERIAL REFERENCES directors(id)
);
CREATE TABLE movie_actor(
    movieID VARCHAR(10) REFERENCES movies(id),
    actorID SERIAL REFERENCES actors(id)
);