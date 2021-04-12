package DAO;

import Database.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements DAO<Genre>{
    private final Connection connection;
    public GenreDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Genre get(int id) {
        try {
            String query = "SELECT * FROM genres WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Genre(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Genre> getByName(String name){
        List<Genre> genres = new ArrayList<>();
        try {
            String query = "SELECT * FROM genres WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                genres.add(new Genre(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genres;
    }
    @Override
    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM genres";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                genres.add(new Genre(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genres;
    }
    @Override
    public void add(Genre genre) {
        try {
            String insert = "INSERT INTO genres(id, name) VALUES (default, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, genre.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
