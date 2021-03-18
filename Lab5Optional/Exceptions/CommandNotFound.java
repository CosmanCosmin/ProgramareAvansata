package Exceptions;

public class CommandNotFound extends Exception{
    public CommandNotFound(String message) {
        super("Command " + message + " not found!");
    }
}
