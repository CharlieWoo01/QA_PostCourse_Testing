package qa;

import org.junit.Before;
import org.junit.Test;

import java.util.InvalidPropertiesFormatException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Test Plan Scenarios:
 *
 * Case-sensitive username:
 * - Upper case username
 * - Lower case username
 * - Camelcase username
 *
 * Username not null:
 * - Null username
 *
 * Username Char limit:
 * - 1 char username
 * - 8 char username
 *
 * Only contain letters:
 * - Username with letters
 * - Username with digits
 *
 * Must not contain special chars
 * - Username with ~>?@%$£
 *
 * Unique username:
 * - Username which matches existing stored username
 */
public class UsernameValidationTests {

//    private UserAccountDBStub mockedDb;
//
//    private UserAccountManager mockAccountManager;
//    @Before()
//    public void setUp() {
//        mockedDb = mock(UserAccountDBStub.class);
//        mockAccountManager = mock(UserAccountManager.class);
//    }

//    @Test()
//    public void GivenUpperCaseUsernameRegistration_ShouldPass() {
//        UserAccountDBStub mockDb = new UserAccountDBStub();
//        Address address = new Address("SomeNumber", "AnotherAddress", "SW1A 1AA", "London", mockDb);
//        User user = new User("MYUSERNAME", "password123$", address);
//
//        boolean registered = mockDb.register(user);
//
//        assertTrue(registered);
//    }

    @Test
    public void GivenUsernameContainsUpperCase_ShouldPassValidation() {
        boolean result = Utils.isValidUsername("USERNAME");
        assertTrue(result);
    }

    @Test
    public void GivenUsernameContainsLowerCase_ShouldPassValidation() {
        boolean result = Utils.isValidUsername("username");
        assertTrue(result);
    }

    @Test
    public void GivenUsernameContainsNull_ShouldFailValidation() {
        boolean result = Utils.isValidUsername(null);
        assertFalse(result);
    }

    @Test
    public void GivenUsernameContainsNumber_ShouldFailValidation() {
        boolean result = Utils.isValidUsername("USERNAME123");
        assertFalse(result);
    }

    @Test
    public void GivenUsernameContainsIllegalChar_ShouldFailValidation() {
        String[] illegalUsernames = {
                "~user123",
                "test@user",
                "us%ername",
                "123$username",
                "!invalid",
                "£AAAAA",
                "  ",
                ""
        };

        for (String illegalUsername : illegalUsernames) {
            boolean result = Utils.isValidUsername(illegalUsername);
            assertFalse(result);
        }
    }














//    @Test()
//    public void GivenLowercaseUsernameRegistration_ShouldPass() {
//        UserAccountDBStub mockDb = new UserAccountDBStub();
//        Address address = new Address("SomeNumber", "AnotherAddress", "SW1A 1AA", "London", mockDb);
//        User user = new User("anotherusername", "password123$", address);
//
//        boolean registered = mockDb.register(user);
//
//        assertTrue(registered);
//    }
//
//    @Test()
//    public void GivenCamelCaseUsernameRegistration_ShouldPass() {
//        UserAccountDBStub mockDb = new UserAccountDBStub();
//        Address address = new Address("SomeNumber", "AnotherAddress", "SW1A 1AA", "London", mockDb);
//        User user = new User("yetAnotherUsername", "password123$", address);
//
//        boolean registered = mockDb.register(user);
//
//        assertTrue(registered);
//    }
//
//    // This test does not seem right
//    @Test(expected = NullPointerException.class)
//    public void GivenNullUsernameRegistration_ShouldThrowInvalidUsernameFormatException() {
//        UserAccountDBStub mockDb = new UserAccountDBStub();
//        Address address = new Address("SomeNumber", "AnotherAddress", "SW1A 1AA", "London", mockDb);
//        User user = new User(null, "password123$", address);
//
//        // I changed this to test outcome which as passes is weird
//        when(mockedDb.register(user)).thenThrow(InvalidPropertiesFormatException.class);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void givenInvalidUsernameFormat_ContainingSpecialChars_ShouldThrowIllegalArgumentException() {
//        UserAccountDBStub mockDb = new UserAccountDBStub();
//        Address address = new Address("number", "address", "SW1A 1AA", "London", mockDb);
//        User user = new User("invalid@username", "password123!", address);
//
//        mockDb.register(user);
//    }
}
