package qa;

public class Main {
    public static void main(String args[]) {

        UserAccountDBStub userAccountDBStub = new UserAccountDBStub();
        UserAccountManager userAccountManager = new UserAccountManager(userAccountDBStub);
        Address address = new Address("SomeNumber", "AnotherAddress", "SW1A 1AA", "London", userAccountDBStub);
        User user = new User("useraaaa", "password123$", address);

//        boolean registered = userAccountManager.register(user);

//        System.out.println(registered);

    }
}
