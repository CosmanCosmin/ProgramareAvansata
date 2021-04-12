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
    public Movie get(int id) {
        try {
            String query = "SELECT * FROM movies WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Movie(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("release_date"), resultSet.getInt("duration"), resultSet.getFloat("score"));
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
            String query = "SELECT * FROM movies WHERE title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                movies.add(new Movie(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("release_date"), resultSet.getInt("duration"), resultSet.getFloat("score")));
            }
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
            String query = "SELECT * FROM movies";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                movies.add(new Movie(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("release_date"), resultSet.getInt("duration"), resultSet.getFloat("score")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movies;
    }
    @Override
    public void add(Movie movie) {
        try {
            String insert = "INSERT INTO movies(id, title, release_date, duration, score) VALUES (default, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDate());
            preparedStatement.setInt(3, movie.getDuration());
            preparedStatement.setFloat(4,movie.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
