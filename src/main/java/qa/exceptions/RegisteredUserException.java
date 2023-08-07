package qa.exceptions;

public class RegisteredUserException extends Exception{
    public RegisteredUserException() {
        super("Error! This user is already registered");
    }
}
