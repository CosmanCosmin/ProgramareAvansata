package DAO;

import Database.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO implements DAO<Director>{
    private final Connection connection;
    public DirectorDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Director get(String id) {
        try {
            String query = "SELECT * FROM directors WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Director(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Director> getByName(String name){
        List<Director> directors = new ArrayList<>();
        try {
            String query = "SELECT * FROM directors WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                directors.add(new Director(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return directors;
    }
    @Override
    public List<Director> getAll() {
        List<Director> directors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM directors";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                directors.add(new Director(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return directors;
    }
    @Override
    public void add(Director director) {
        try {
            String insert = "INSERT INTO directors(id, name) VALUES (default, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, director.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
