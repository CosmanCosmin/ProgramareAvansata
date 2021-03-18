package Multimedia;

import Exceptions.NameNullException;
import Exceptions.PathNullException;

import java.io.Serializable;

public abstract class Multimedia implements Serializable {
    private String name;
    private String path;
    public Multimedia(String name, String path) throws NameNullException, PathNullException {
        if (name == null) throw new NameNullException();
        if (path == null) throw new PathNullException();
        this.name = name;
        this.path = path;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws NameNullException{
        if (name == null) throw new NameNullException();
        this.name = name;
    }
    public String getPath(){
        return path;
    }
    public void setPath(String path) throws PathNullException {
        if (path == null) throw new PathNullException();
        this.path = path;
    }
}
