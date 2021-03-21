package Commands;

import Base.Catalog;
import Multimedia.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand extends Command{
    public ReportCommand(Catalog catalog) {
        try {
            Configuration config = new Configuration();
            config.setDirectoryForTemplateLoading(new File("C:\\Users\\cosmi\\IdeaProjects\\PA-Lab5-Optional\\templates"));
            config.setDefaultEncoding("UTF-8");
            config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template template = config.getTemplate("template.ftl");
            FileWriter writer = new FileWriter("catalog.html");
            Map<String, List<Multimedia>> root = new HashMap<>();
            List<Multimedia> songs = new ArrayList<Multimedia>();
            List<Multimedia> images = new ArrayList<Multimedia>();
            for (Multimedia item : catalog.getItems()) {
                if (item instanceof Song){
                    songs.add(item);
                }
                else{
                    images.add(item);
                }
            }
            root.put("songs", songs);
            root.put("images", images);
            template.process(root, writer);
            File file = new File("C:\\Users\\cosmi\\IdeaProjects\\PA-Lab5-Optional\\catalog.html");
            if(Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                if(file.exists()){
                    desktop.open(file);
                }
            }
        }
        catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }
}
