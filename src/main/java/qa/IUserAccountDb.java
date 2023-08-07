package qa;

import java.util.ArrayList;

public interface IUserAccountDb
{
    ArrayList<String> getCityNames();

    boolean isARegisteredUsername(User user);

    boolean isAnExistingUser(User user);

    int getLoginAttempts(boolean isExistingUser);

    boolean registeredUser(User user);
}
