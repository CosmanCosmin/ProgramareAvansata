import Exceptions.NameNullException;
import Exceptions.PathNullException;

public class Main {
    public static void main(String[] args) throws NameNullException, PathNullException {
        Multimedia image1 = new Image("koala", "C:\\Users\\cosmi\\Downloads\\koala.jpg", 1132, 1113);
        Multimedia song1 = new Song("marmot", "C:\\Users\\cosmi\\Downloads\\marmot.mp3", "the marmot");
        Catalog catalog1 = new Catalog();
        catalog1.add(image1);
        // catalog1.play(image1);
        catalog1.add(song1);
        // catalog1.play(song1);
        catalog1.print();
        catalog1.save();
        Catalog catalog2 = new Catalog();
        catalog2.load("catalog.ser");
        catalog2.print();
    }
}
