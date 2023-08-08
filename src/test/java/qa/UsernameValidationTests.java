package qa;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsernameValidationTests {

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
    public void GivenUsernameDoesNotMeetLength_ShouldFailValidation() {
        boolean result = Utils.isValidUsername("a");
        assertFalse(result);
    }

    @Test
    public void GivenUsernameExceedsLength_ShouldFailValidation() {
        boolean result = Utils.isValidUsername("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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
}
