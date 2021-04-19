package Base;

import DAO.*;
import Database.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBConnect connect = DBConnect.getInstance();
        MovieDAO movieDAO = new MovieDAO(connect.getConnection());
        GenreDAO genreDAO = new GenreDAO(connect.getConnection());
        ActorDAO actorDAO = new ActorDAO(connect.getConnection());
        DirectorDAO directorDAO = new DirectorDAO(connect.getConnection());
        //DBFill fill = new DBFill(connect); //fills the database, takes a very long time so don't do it
        List<Movie> movies = movieDAO.getAll();
        List<Genre> genres = genreDAO.getAll();
        List<Actor> actors = actorDAO.getAll();
        List<Director> directors = directorDAO.getAll();
        for (Movie movie: movies) {
            System.out.println(movie);
        }
        for (Genre genre : genres) {
            System.out.println(genre);
        }
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        for (Director director : directors) {
            System.out.println(director);
        }
        connect.closeConnection();
    }
}
