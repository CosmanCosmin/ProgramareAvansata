package Exceptions;

public class PathNullException extends Exception{
    public PathNullException() {
        super("Path shouldn't be empty!");
    }
}
