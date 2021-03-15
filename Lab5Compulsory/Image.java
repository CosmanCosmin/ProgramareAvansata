import Exceptions.NameNullException;
import Exceptions.PathNullException;

public class Image extends Multimedia {
    private int sizeX;
    private int sizeY;
    public Image(String name, String path, int sizeX, int sizeY) throws NameNullException, PathNullException {
        super(name, path);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    public int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    @Override
    public String toString() {
        return "Image{" +
                "Name:" + this.getName() +
                ", Path:" + this.getPath() +
                ", sizeX:" + sizeX +
                ", sizeY:" + sizeY +
                "}";
    }
}
