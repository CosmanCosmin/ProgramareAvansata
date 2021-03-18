package Exceptions;

public class ArtistNullException extends Exception{
    public ArtistNullException() {
        super("Artist shouldn't be empty!");
    }
}
