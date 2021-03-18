package Multimedia;

import Exceptions.ArtistNullException;
import Exceptions.NameNullException;
import Exceptions.PathNullException;

public class Song extends Multimedia{
    private String artist;
    public Song(String name, String path, String artist) throws NameNullException, PathNullException, ArtistNullException {
        super(name, path);
        if (artist == null) throw new ArtistNullException();
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    @Override
    public String toString() {
        return "Song{" +
                "name=" + getName() +
                ", artist=" + artist +
                ", path=" + getPath() +
                '}';
    }
}
