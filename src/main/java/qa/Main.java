package qa;

import qa.exceptions.InvalidLoginCredentialsException;
import qa.exceptions.InvalidUKAddressException;
import qa.exceptions.InvalidUserFormatException;
import qa.exceptions.RegisteredUserException;
import qa.exceptions.TooManyLoginAttemptsException;

public class Main {
    public static void main(String args[]) throws InvalidUKAddressException, RegisteredUserException, TooManyLoginAttemptsException, InvalidLoginCredentialsException, InvalidUserFormatException {

        UserAccountDBStub userAccountDBStub = new UserAccountDBStub();
        UserAccountManager userAccountManager = new UserAccountManager(userAccountDBStub);
        Address address = new Address("SomeNumber", "AnotherAddress", "SW1A 1AA", "London", userAccountDBStub);
        User user = new User("useraaaa", "password2$", address);
        User user2 = new User("userffff", "password2$", address);

        boolean registered = userAccountManager.register(user2);
        boolean loggedIn = userAccountManager.login(user);

        System.out.println(registered);
        System.out.println(loggedIn);

    }
}
