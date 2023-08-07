package qa;

import qa.exceptions.InvalidLoginCredentialsException;
import qa.exceptions.RegisteredUserException;
import qa.exceptions.TooManyLoginAttemptsException;

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
    public boolean login(User user) throws TooManyLoginAttemptsException, InvalidLoginCredentialsException {
        if (userAccountDb.getLoginAttempts(userAccountDb.isAnExistingUser(user)) >= 3) {
            throw new TooManyLoginAttemptsException();
        }

        boolean isRegistered = userAccountDb.isAnExistingUser(user);
        if (!isRegistered) {
            throw new InvalidLoginCredentialsException();
        }


        return !userAccountDb.registeredUser(user);
    }

    public boolean register(User user) throws RegisteredUserException {
        if (userAccountDb.isARegisteredUsername(user)) {
            throw new RegisteredUserException();
        }

        userAccountDb.registeredUser(user);
        return true;
    }
}
