package qa;

// Uses the actual database or a stub/mock database to login or register a user
public class UserAccountManager
{
    IUserAccountDb userAccountDb;

    public UserAccountManager(IUserAccountDb userAccountDb)
    {
        this.userAccountDb = userAccountDb;
    }

    // Logs user in. 
    // The username and password format has already been validated
    public boolean login(User user)
    {
    	// Also implement this
        //	if number of tries to login is > 3    
        //      throw an exception

        if (!userAccountDb.isRegisteredUser(user))
            throw new IllegalArgumentException();

        return userAccountDb.register(user);
    }

    public boolean register(User user)
    {
        if (userAccountDb.isRegisteredUser(user))
            throw new IllegalArgumentException();

        userAccountDb.register(user);

        return true;
    }
}
