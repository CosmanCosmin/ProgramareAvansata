package Exceptions;

public class NameNullException extends Exception{
    public NameNullException() {
        super("Name shouldn't be empty!");
    }
}
