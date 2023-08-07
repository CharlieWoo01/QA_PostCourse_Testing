package qa.exceptions;

public class InvalidUserFormatException extends Exception{
    public InvalidUserFormatException() {
        super("Error! Invalid user format for username or password");
    }
}
