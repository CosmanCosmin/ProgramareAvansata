package DAO;

import Database.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO implements DAO<Actor>{
    private final Connection connection;
    public ActorDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Actor get(String id) {
        try {
            String query = "SELECT * FROM actors WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Actor(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Actor> getByName(String name){
        List<Actor> actors = new ArrayList<>();
        try {
            String query = "SELECT * FROM actors WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                actors.add(new Actor(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actors;
    }
    @Override
    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM genres";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                actors.add(new Actor(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actors;
    }
    @Override
    public void add(Actor actor) {
        try {
            String insert = "INSERT INTO actors(id, name) VALUES (default, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, actor.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
