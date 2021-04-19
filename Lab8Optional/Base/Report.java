package Base;

import DAO.MovieDAO;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Report {
    public Report(MovieDAO movieDAO) {
        Map<String, Object> items = new HashMap<>();
        items.put("Top", movieDAO.getTopRated());
        MustacheFactory mustacheFactory = new DefaultMustacheFactory();
        Mustache mustache = mustacheFactory.compile("C:/Users/cosmi/IdeaProjects/PA-Lab8-Compulsory/src/main/java/Views/movies.mustache");
        StringWriter stringWriter = new StringWriter();
        mustache.execute(stringWriter, items);
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\cosmi\\IdeaProjects\\PA-Lab8-Compulsory\\src\\main\\java\\Views\\index.html");
            fileWriter.write(stringWriter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
