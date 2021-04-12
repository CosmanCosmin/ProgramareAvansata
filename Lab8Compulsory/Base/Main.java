package Base;

import DAO.*;
import Database.*;

public class Main {
    public static void main(String[] args) {
        DBConnect connect = DBConnect.getInstance();
        MovieDAO movieDAO = new MovieDAO(connect.getConnection());
        GenreDAO genreDAO = new GenreDAO(connect.getConnection());
        movieDAO.add(new Movie(0, "The Bourne Legacy", "2012-07-30", 135, 6.6f));
        System.out.println(movieDAO.getAll());
        System.out.println(movieDAO.get(1));
        System.out.println(movieDAO.getByName("The Bourne Legacy"));
        genreDAO.add(new Genre(0, "Horror"));
        System.out.println(genreDAO.get(2));
        System.out.println(genreDAO.getByName("Action"));
        genreDAO.add(new Genre(0, "Drama"));
        System.out.println(genreDAO.getAll());
        connect.closeConnection();
    }
}
