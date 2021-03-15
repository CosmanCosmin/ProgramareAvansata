import Exceptions.NameNullException;
import Exceptions.PathNullException;

public class Song extends Multimedia {
    private String artist;
    public Song(String name, String path, String artist) throws NameNullException, PathNullException {
        super(name, path);
        if (artist == null) throw new NameNullException("Artist name shouldn't be null");
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) throws NameNullException {
        if (artist == null) throw new NameNullException("Artist name shouldn't be null");
        this.artist = artist;
    }
    @Override
    public String toString() {
        return "Song{" +
                "Name:" + this.getName() +
                ", Artist:" + artist +
                ", Path:" + this.getPath() +
                "}";
    }
}
