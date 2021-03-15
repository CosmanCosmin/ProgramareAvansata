import Exceptions.PathNullException;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Multimedia> items;
    public Catalog() {
        this.items = new ArrayList<>();
    }
    public List<Multimedia> getItems() {
        return items;
    }
    public void setItems(List<Multimedia> items) {
        this.items = items;
    }
    public void add(Multimedia item){
        items.add(item);
    }
    public void print(){
        System.out.println(items);
    }
    /**
     * opens a multimedia item like a song or an image
     * @param item the multimedia item to be opened
     */
    public void play(Multimedia item){
        try {
            File file = new File(item.getPath());
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
    /**
     * saves the catalog to a file named catalog.ser using object serialization
     */
    public void save(){
        try {
            FileOutputStream fileOut = new FileOutputStream("catalog.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Saved to catalog.ser");
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }
    /**
     * deserializes a file into a catalog object
     * @param filePath the path to the serialized file
     * @throws PathNullException throws an exception if the path is null
     */
    public void load(String filePath) throws PathNullException {
        if (filePath == null) throw new PathNullException("Path shouldn't be null");
        Catalog c;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Catalog) in.readObject();
            in.close();
            fileIn.close();
            this.setItems(c.getItems());
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
