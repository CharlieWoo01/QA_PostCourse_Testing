package qa;

import qa.exceptions.InvalidUserFormatException;

public class User
{
    String userName; 
    String password; 
    Address address; 

    public User(String userName, String password, Address address) throws InvalidUserFormatException {
        if (Utils.isValidUsername(userName))
            this.userName = userName;
        else
            throw new InvalidUserFormatException();

        if (Utils.isValidPassword(password))
            this.password = password;
        else
            throw new InvalidUserFormatException();
        this.address = address;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
