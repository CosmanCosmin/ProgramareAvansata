package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
    private Connection connection;
    private static DBConnect singleInstance = null;
    private DBConnect(){
        String url = "jdbc:postgresql://localhost:5432/javalab";
        Properties properties = new Properties();
        properties.setProperty("user", "cosmin");
        properties.setProperty("password", "abc123");
        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static DBConnect getInstance(){
        if (singleInstance == null){
            singleInstance = new DBConnect();
        }
        return singleInstance;
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
