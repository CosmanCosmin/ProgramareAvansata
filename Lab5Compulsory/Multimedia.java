import Exceptions.NameNullException;
import Exceptions.PathNullException;

import java.io.Serializable;

public abstract class Multimedia implements Serializable {
    private String name;
    private String path;
    public Multimedia(String name, String path) throws NameNullException, PathNullException {
        if (name == null) throw new NameNullException("Name shouldn't be null");
        if (path == null) throw new PathNullException("Path shouldn't be null");
        this.name = name;
        this.path = path;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws NameNullException {
        if (name == null) throw new NameNullException("Name shouldn't be null");
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) throws PathNullException {
        if (path == null) throw new PathNullException("Path shouldn't be null");
        this.path = path;
    }
    @Override
    public abstract String toString();
}
