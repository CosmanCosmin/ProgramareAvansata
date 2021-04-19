package Database;

import DAO.MovieDAO;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class DBFill {
    public DBFill(DBConnect connect) {
        MovieDAO movieDAO = new MovieDAO(connect.getConnection());
        //GenreDAO genreDAO = new GenreDAO(connect.getConnection());
        String fileName = "C:\\Users\\cosmi\\IdeaProjects\\PA-Lab8-Compulsory\\IMDb movies.csv";
        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(fileName))){
            Map<String, String> currentLine;
            while ((currentLine = reader.readMap()) != null){
                Movie movie = new Movie(currentLine.get("imdb_title_id"),
                        currentLine.get("title"),
                        Integer.parseInt(currentLine.get("year")),
                        currentLine.get("date_published"),
                        currentLine.get("genre"),
                        Integer.parseInt(currentLine.get("duration")),
                        currentLine.get("language"),
                        currentLine.get("director"),
                        currentLine.get("actors"),
                        Float.parseFloat(currentLine.get("avg_vote")));
                movieDAO.add(movie);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
