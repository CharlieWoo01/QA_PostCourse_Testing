package qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import qa.exceptions.InvalidUKAddressException;
import qa.exceptions.InvalidUserFormatException;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

public class UserAccountDBStubTests {

    @InjectMocks
    private UserAccountDBStub userAccountDBStub;

    @Mock
    private IUserAccountDb userAccountDbMock;

    @BeforeEach
    public void setUp() throws InvalidUserFormatException, InvalidUKAddressException {
        MockitoAnnotations.initMocks(this);
        userAccountDBStub = new UserAccountDBStub();
    }

    @Test
    public void GivenStoredCities_ShouldEqualLengthOf3() {
        when(userAccountDbMock.getCityNames()).thenReturn(new ArrayList<>());

        assertEquals(3, userAccountDBStub.getCityNames().size());
    }

    @Test
    public void GivenValidUserFormat_Should_SucessfullyRegister() throws InvalidUserFormatException {
        User user = new User("user", "password1$", null);
        when(userAccountDbMock.isARegisteredUsername(user)).thenReturn(true);
        assertTrue(userAccountDBStub.isARegisteredUsername(user));
    }

    @Test
    public void GivenExistingUser_ShouldReturnTrue() throws InvalidUserFormatException {
        User user = new User("user", "password1$", null);
        when(userAccountDbMock.isAnExistingUser(user)).thenReturn(true);
        assertTrue(userAccountDBStub.isAnExistingUser(user));
    }

    @Test
    public void GivenRegisteredUserAfterRegistration_ShouldRegisterAsTrueThenFalse() throws InvalidUserFormatException {
        User newUser = new User("usernametwo", "newPassword123$", null);
        when(userAccountDbMock.registeredUser(newUser)).thenReturn(true, false);
        assertTrue(userAccountDBStub.registeredUser(newUser));
        assertFalse(userAccountDBStub.registeredUser(newUser)); // Already registered user
    }

    @Test
    public void GiveNotExistingUser_ShouldIncreaseLoginAttemptsBy1() {
        when(userAccountDbMock.getLoginAttempts(false)).thenReturn(1, 2);
        assertTrue(userAccountDBStub.getLoginAttempts(false) == 1);
        assertTrue(userAccountDBStub.getLoginAttempts(false) == 2);
    }

    @Test
    public void GivenLoginCredentialsAreValid_ShouldHaveLoginAttemptsAs0() {
        when(userAccountDbMock.getLoginAttempts(true)).thenReturn(0);
        assertTrue(userAccountDBStub.getLoginAttempts(true) == 0);
    }
}
