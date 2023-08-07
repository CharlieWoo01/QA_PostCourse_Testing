package qa.exceptions;

public class InvalidUKAddressException extends Exception{
    public InvalidUKAddressException() {
        super("Error! Invalid UK address format");
    }
}
