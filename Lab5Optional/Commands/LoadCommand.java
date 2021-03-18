package Commands;

import Base.Catalog;
import Exceptions.PathNullException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command{
    public LoadCommand(Catalog catalog, String filePath) throws PathNullException {
        if (filePath == null) throw new PathNullException();
        Catalog c;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Catalog) in.readObject();
            in.close();
            fileIn.close();
            catalog.setItems(c.getItems());
        }
        catch (IOException i){
            i.printStackTrace();
        }
        catch (ClassNotFoundException classNotFoundException){
            System.out.println("Class Catalog not found.");
            classNotFoundException.printStackTrace();
        }
    }
}
