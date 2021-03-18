package Commands;

import Base.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command{
    public SaveCommand(Catalog catalog) {
        try {
            FileOutputStream fileOut = new FileOutputStream("catalog.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(catalog);
            out.close();
            fileOut.close();
            System.out.println("Saved to catalog.ser");
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }
}
