package qa;

public class User
{
    String userName; 
    String password; 
    Address address; 

    public User(String userName, String password, Address address)
    {
        if (Utils.isValidUsername(userName))
            this.userName = userName;
        else
            throw new IllegalArgumentException();

        if (Utils.isValidPassword(password))
            this.password = password;
        else
            throw new IllegalArgumentException();
        this.address = address;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
