package Multimedia;

import Exceptions.NameNullException;
import Exceptions.PathNullException;

public class Image extends Multimedia {
    public Image(String name, String path) throws NameNullException, PathNullException {
        super(name, path);
    }
    @Override
    public String toString() {
        return "Image{" +
                "name=" + getName() +
                ", path=" + getPath() +
                "}";
    }
}
