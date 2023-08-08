package qa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
    /**
     * Validates that the username is of expected format below:
     * * Not case-sensitive
     * * No whitespaces or tabs
     * * Not null
     * * Greater than 2 chars
     * * Only contain alphabetic characters
     * * Must not contain the following ~<>@%$£
     * @param inputString
     * @return
     */
    public static boolean isValidUsername(String inputString)
    {
        boolean validate = false;
        if (inputString != null) {
            validate = inputString.matches("^(?!.*[\\t\\n\\r\\[\\]$£<>~;'@])(?!.*\\d)^[A-Za-z\\.-]{2,50}$");
        }
        return validate;
    }

    /**
     * Validates that the password is of expected format below:
     * Case-sensitive
     * No whitespaces or tabs
     * Not null
     * Must contain at least 1 number
     * Must contain at least one of the following: ~@%$£
     * Must not contain <>;='or''--'
     * Minimum 8 chars
     * @param inputString
     * @return
     */
    public static boolean isValidPassword(String inputString)
    {
        boolean validate = false;
        if (inputString != null) {
            validate = inputString.matches("^(?=.*[0-9])(?!.*[<>;=\\-|])(?=.*[~@%$£])[^\s\t]{8,}$");
        }
        return validate;
    }

    /**
     * Validates that the postcode is a valid UK format
     * @param postCode
     * @return
     */
    public static boolean isValidUKPostCode(String postCode)
    {
        boolean validate = false;
        if (postCode != null) {
            String regex = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(postCode.trim());
            validate = matcher.matches();
        }
    	return validate;
    }

    /**
     * Validates that the house/flat number is only a number and that a dash can be included
     * @param houseFlatNumber
     * @return
     */
    public static boolean isValidAddressHouseFlatNumber(String houseFlatNumber)
    {
        return houseFlatNumber != null && houseFlatNumber.matches("^[-0-9]+$");
    }

    /**
     * Validates that the address line is not null
     * @param addressLine
     * @return
     */
    public static boolean isValidAddressLine(String addressLine)
    {
        return addressLine != null;
    }
}
