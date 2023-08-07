package qa.exceptions;

public class InvalidLoginCredentialsException extends Exception{
    public InvalidLoginCredentialsException() {
        super("Error! Invalid login credentials");
    }
}
