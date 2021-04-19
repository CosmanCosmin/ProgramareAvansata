package DAO;

import Database.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements DAO<Movie> {
    private final Connection connection;
    public MovieDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Movie get(String id) {
        try {
            String query = "select movies.id, title, release_year, release_date, string_agg(distinct g.name, ', ') as genres," +
                           " duration, language, string_agg(distinct d.name, ', ') as directors," +
                           " string_agg(distinct a.name, ', ') as actors, score from movies" +
                           " join movie_genre mg on movies.id = mg.movieID join genres g on g.id = mg.genreID" +
                           " join movie_director md on movies.id = md.movieID join directors d on d.id = md.directorID" +
                           " join movie_actor ma on movies.id = ma.movieID join actors a on a.id = ma.actorID" +
                           " where movies.id = ? group by movies.id;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Movie(resultSet.getString("id"),
                                 resultSet.getString("title"),
                                 resultSet.getInt("release_year"),
                                 resultSet.getString("release_date"),
                                 resultSet.getString("genres"),
                                 resultSet.getInt("duration"),
                                 resultSet.getString("language"),
                                 resultSet.getString("directors"),
                                 resultSet.getString("actors"),
                                 resultSet.getFloat("score"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Movie> getByName(String name){
        List<Movie> movies = new ArrayList<>();
        try {
            String query =  "select movies.id, title, release_year, release_date, string_agg(distinct g.name, ', ') as genres," +
                            " duration, language, string_agg(distinct d.name, ', ') as directors," +
                            " string_agg(distinct a.name, ', ') as actors, score from movies" +
                            " join movie_genre mg on movies.id = mg.movieID" +
                            " join genres g on g.id = mg.genreID join movie_director md on movies.id = md.movieID" +
                            " join directors d on d.id = md.directorID join movie_actor ma on movies.id = ma.movieID" +
                            " join actors a on a.id = ma.actorID" +
                            " where title = ? group by movies.id;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                movies.add(new Movie(resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("release_year"),
                        resultSet.getString("release_date"),
                        resultSet.getString("genres"),
                        resultSet.getInt("duration"),
                        resultSet.getString("language"),
                        resultSet.getString("directors"),
                        resultSet.getString("actors"),
                        resultSet.getFloat("score")));}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movies;
    }
    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "select movies.id, title, release_year," +
                           " release_date, string_agg(distinct g.name, ', ') as genres, duration, language," +
                           " string_agg(distinct d.name, ', ') as directors, string_agg(distinct a.name, ', ') as actors," +
                           " score from movies join movie_genre mg on movies.id = mg.movieID join genres g on g.id = mg.genreID" +
                           " join movie_director md on movies.id = md.movieID join directors d on d.id = md.directorID" +
                           " join movie_actor ma on movies.id = ma.movieID join actors a on a.id = ma.actorID group by movies.id;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                movies.add(new Movie(resultSet.getString("id"),
                                     resultSet.getString("title"),
                                     resultSet.getInt("release_year"),
                                     resultSet.getString("release_date"),
                                     resultSet.getString("genres"),
                                     resultSet.getInt("duration"),
                                     resultSet.getString("language"),
                                     resultSet.getString("directors"),
                                     resultSet.getString("actors"),
                                     resultSet.getFloat("score")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movies;
    }
    @Override
    public void add(Movie movie) {
        try {
            //insert the movie
            String insertMovie = "INSERT INTO movies(id, title, release_year, release_date, duration, language, score) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertMovieQuery = connection.prepareStatement(insertMovie);
            insertMovieQuery.setString(1, movie.getId());
            insertMovieQuery.setString(2, movie.getTitle());
            insertMovieQuery.setInt(3, movie.getYear());
            insertMovieQuery.setString(4, movie.getDate());
            insertMovieQuery.setInt(5, movie.getDuration());
            insertMovieQuery.setString(6, movie.getLanguage());
            insertMovieQuery.setFloat(7, movie.getScore());
            insertMovieQuery.executeUpdate();
            //insert its genres
            String genreExists = "SELECT * FROM genres WHERE name = ?";
            String genreInsert = "INSERT INTO genres(id, name) VALUES(default, ?)";
            String[] genres = movie.getGenres().split(", ");
            for (String genre: genres) {
                PreparedStatement genreExistsQuery = connection.prepareStatement(genreExists);
                genreExistsQuery.setString(1, genre);
                ResultSet resultSet = genreExistsQuery.executeQuery();
                if (!resultSet.next()){
                    PreparedStatement genreInsertQuery = connection.prepareStatement(genreInsert);
                    genreInsertQuery.setString(1, genre);
                    genreInsertQuery.executeUpdate();
                }
                String genreGetId = "SELECT id FROM genres WHERE name = ?";
                String genreMovieAssociation = "INSERT INTO movie_genre(movieID, genreID) VALUES(?, ?)";
                PreparedStatement genreGetIdQuery = connection.prepareStatement(genreGetId);
                genreGetIdQuery.setString(1, genre);
                ResultSet resultSet1 = genreGetIdQuery.executeQuery();
                resultSet1.next();
                PreparedStatement genreMovieAssociationQuery = connection.prepareStatement(genreMovieAssociation);
                genreMovieAssociationQuery.setString(1, movie.getId());
                genreMovieAssociationQuery.setInt(2, resultSet1.getInt("id"));
                genreMovieAssociationQuery.executeUpdate();
            }
            //insert its actors
            String actorExists = "SELECT * FROM actors WHERE name = ?";
            String actorInsert = "INSERT INTO actors(id, name) VALUES(default, ?)";
            String[] actors = movie.getActors().split(", ");
            for (String actor: actors) {
                PreparedStatement actorExistsQuery = connection.prepareStatement(actorExists);
                actorExistsQuery.setString(1, actor);
                ResultSet resultSet = actorExistsQuery.executeQuery();
                if (!resultSet.next()){
                    PreparedStatement actorInsertQuery = connection.prepareStatement(actorInsert);
                    actorInsertQuery.setString(1, actor);
                    actorInsertQuery.executeUpdate();
                }
                String actorGetId = "SELECT id FROM actors WHERE name = ?";
                String actorMovieAssociation = "INSERT INTO movie_actor(movieID, actorID) VALUES(?, ?)";
                PreparedStatement actorGetIdQuery = connection.prepareStatement(actorGetId);
                actorGetIdQuery.setString(1, actor);
                ResultSet resultSet1 = actorGetIdQuery.executeQuery();
                resultSet1.next();
                PreparedStatement actorMovieAssociationQuery = connection.prepareStatement(actorMovieAssociation);
                actorMovieAssociationQuery.setString(1, movie.getId());
                actorMovieAssociationQuery.setInt(2, resultSet1.getInt("id"));
                actorMovieAssociationQuery.executeUpdate();
            }
            //insert its directors
            String directorExists = "SELECT * FROM directors WHERE name = ?";
            String directorInsert = "INSERT INTO directors(id, name) VALUES(default, ?)";
            String[] directors = movie.getDirectorName().split(", ");
            for (String director: directors) {
                PreparedStatement directorExistsQuery = connection.prepareStatement(directorExists);
                directorExistsQuery.setString(1, director);
                ResultSet resultSet = directorExistsQuery.executeQuery();
                if (!resultSet.next()){
                    PreparedStatement directorInsertQuery = connection.prepareStatement(directorInsert);
                    directorInsertQuery.setString(1, director);
                    directorInsertQuery.executeUpdate();
                }
                String directorGetId = "SELECT id FROM directors WHERE name = ?";
                String directorMovieAssociation = "INSERT INTO movie_director(movieID, directorID) VALUES(?, ?)";
                PreparedStatement directorGetIdQuery = connection.prepareStatement(directorGetId);
                directorGetIdQuery.setString(1, director);
                ResultSet resultSet1 = directorGetIdQuery.executeQuery();
                resultSet1.next();
                PreparedStatement directorMovieAssociationQuery = connection.prepareStatement(directorMovieAssociation);
                directorMovieAssociationQuery.setString(1, movie.getId());
                directorMovieAssociationQuery.setInt(2, resultSet1.getInt("id"));
                directorMovieAssociationQuery.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
