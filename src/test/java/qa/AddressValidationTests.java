package qa;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressValidationTests {

    @Test
    public void GivenAddressNumberContainsOnlyNumber_ShouldPassValidation() {
        boolean result = Utils.isValidAddressHouseFlatNumber("101");
        assertTrue(result);
    }

    @Test
    public void GivenAddressNumberContainsNumberAndDash_ShouldPassValidation() {
        boolean result = Utils.isValidAddressHouseFlatNumber("11-15");
        assertTrue(result);
    }

    @Test
    public void GivenAddressNumberContainsAlphabetic_ShouldFailValidation() {
        boolean result = Utils.isValidAddressHouseFlatNumber("100 Bananas");
        assertFalse(result);
    }

    @Test
    public void GivenAddressNumberContainsNull_ShouldFailValidation() {
        boolean result = Utils.isValidAddressHouseFlatNumber(null);
        assertFalse(result);
    }

    @Test
    public void GivenAddressLineContainsNull_ShouldFailValidation() {
        boolean result = Utils.isValidAddressLine(null);
        assertFalse(result);
    }

    @Test
    public void GivenAddressLineContainsString_ShouldPassValidation() {
        boolean result = Utils.isValidAddressLine("28, some road, another street");
        assertTrue(result);
    }

    @Test
    public void GivenPostcodeIsNull_ShouldFailValidation() {
        boolean result = Utils.isValidUKPostCode(null);
        assertFalse(result);
    }


    @Test
    public void GivenPostcodeIsValidFormat_ShouldPassValidation() {
        String[] ukPostcodes = {
                "AA9A 9AA",
                "A9A 9AA",
                "A9 9AA",
                "A99 9AA",
                "AA9 9AA",
                "AA99 9AA",
                "AA9 9AA",
                "AA99 9AA",
                "A9A 9AA",
                "A99 9AA",
                "A9 9AA",
                "A99 9AA",
                "A9A 9AA",
                "A99 9AA",
                "A9 9AA",
                "A99 9AA"
        };

        for (String ukPostcode : ukPostcodes) {
            boolean result = Utils.isValidUKPostCode(ukPostcode);
            assertTrue(result);
        }
    }

    @Test
    public void GivenPostcodeIsInvalidFormat_ShouldFailValidation() {
        String[] invalidUkPostcodes = {
                "1234 ABC",
                "AB12 3CD4",
                "A12 12345",
                "ABCD 123",
                "A1A 1A1A",
                "AB1 23CD",
                "AB12 34",
                "AB1 2CD",
                "AB12 CDE",
                "12345 ABC",
                "AB1 DEF"
        };

        for (String invalidUkPostcode : invalidUkPostcodes) {
            boolean result = Utils.isValidUKPostCode(invalidUkPostcode);
            assertFalse(result);
        }
    }
}
