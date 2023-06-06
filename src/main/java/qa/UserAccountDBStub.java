package qa;

import java.util.ArrayList;

public class UserAccountDBStub implements IUserAccountDb {

	// Database in memory
    ArrayList<String> cities;
    ArrayList<User> users;

    public UserAccountDBStub() throws IllegalArgumentException
    {
    	users = new ArrayList<>();
    	cities = new ArrayList<>();

        // Add the cities to the memory database
        cities.add("London");
        cities.add("Manchester");
        cities.add("Birmingham");

        // Add the users to the memory database
        Address address1 = new Address("1", "Street 1", "SW1A 1AA", "London", this);
        User user1 = new User("user", "password1$", address1);
        users.add(user1);

        Address address2 = new Address("2", "Street 2", "SW1F 1AA", "Manchester", this);
        User user2 = new User("useraaaa", "password2$", address2);
        users.add(user2);
    }

    public ArrayList<String> getCityNames()
    {
        return cities;
    }

    public boolean isAnExistingUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            User userIndex = users.get(i);
            if (userIndex.getUsername().equalsIgnoreCase(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isRegisteredUser(User user)
    {
        for (int i = 0; i < users.size(); i++)
        {
            User userIndex = users.get(i);
            if (userIndex.getUsername().equalsIgnoreCase(user.getUsername()))
            {
                if (userIndex.getPassword().equals(user.getPassword()))
                    return true;
            }
            return false;
        }
        return true;
    }

    public boolean register(User user)
    {
        if (isAnExistingUser(user)) {
            return false;
        }

        users.add(user);
        return true;
    }
}
