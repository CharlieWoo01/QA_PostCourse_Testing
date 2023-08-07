package qa.exceptions;

public class TooManyLoginAttemptsException extends Exception{
    public TooManyLoginAttemptsException() {
        super("Too many login attempts. Please try another time");
    }
}
