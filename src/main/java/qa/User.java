package qa;

public class User
{
    String userName; 
    String password; 
    Address address; 

    public User(String userName, String password, Address address)
    {
        if (Utils.isAlphabetic(userName) && userName.length() > 2)
            this.userName = userName;
        else
            throw new IllegalArgumentException();

        if (isValidPasswordFormat(password))
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

    private boolean isValidPasswordFormat(String password)
    {
        return (password != null && password.length() > 8 && Utils.hasExtraPasswordChars(password));
    }
}
