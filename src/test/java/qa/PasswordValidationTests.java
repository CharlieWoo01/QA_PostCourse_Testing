package qa;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordValidationTests {

    @Test
    public void GivenValidPasswordAllowsCaseSensitive_ShouldPassValidation() {
        boolean result = Utils.isValidPassword("Password1$");
        assertTrue(result);
    }

    @Test
    public void GivenPasswordContainsNoNumber_ShouldFailValidation() {
        boolean result = Utils.isValidPassword("password%");
        assertFalse(result);
    }

    @Test
    public void GivenPasswordContainsNull_ShouldFailValidation() {
        boolean result = Utils.isValidPassword(null);
        assertFalse(result);
    }

    @Test
    public void GivenPasswordContainsSpace_ShouldFailValidation() {
        boolean result = Utils.isValidPassword("Password$1 ");
        assertFalse(result);
    }

    @Test
    public void GivenPasswordDoesNotMeetLength_ShouldFailValidation() {
        boolean result = Utils.isValidPassword("as2$s");
        assertFalse(result);
    }

    @Test
    public void GivenPasswordContainsIllegalChar_ShouldFailValidation() {
        String[] illegalPasswords = {
                "<password123",
                ">password123",
                "Password12;",
                "pass1=rrr",
                "passing1|",
                "passed6--",
        };

        for (String illegalPassword : illegalPasswords) {
            boolean result = Utils.isValidPassword(illegalPassword);
            assertFalse(result);
        }
    }

    @Test
    public void GivenValidPasswordContainsLegalChar_ShouldPassValidation() {
        String[] illegalPasswords = {
                "~password123",
                "@password123",
                "Password12%",
                "passws1$",
                "pass£ing1",
        };

        for (String illegalPassword : illegalPasswords) {
            boolean result = Utils.isValidPassword(illegalPassword);
            assertTrue(result);
        }
    }
}
