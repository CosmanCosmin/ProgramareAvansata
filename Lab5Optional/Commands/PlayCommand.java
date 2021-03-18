package Commands;

import Base.Catalog;

import java.awt.*;
import java.io.File;

public class PlayCommand extends Command{
    public PlayCommand(Catalog catalog, int index) {
        try {
            File file = new File(catalog.getItems().get(index).getPath());
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Not supported!");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
