package qa;

import qa.exceptions.InvalidUKAddressException;

public class Address
{
    IUserAccountDb userAccountDb;
    
    public String number;
    public String addressLine;
    public String postCode;
    public String city;

    public Address(String number, String addressLine, 
    		String postCode, String city,
    		IUserAccountDb userAccountDb) throws InvalidUKAddressException {

        this.userAccountDb = userAccountDb;
        this.number = number;
        this.addressLine = addressLine;
        if (isValidCity(city))
            this.city = city;
        else
            throw new InvalidUKAddressException();

        if (Utils.isValidUKPostCode(postCode))
            this.postCode = postCode;
        else
            throw new InvalidUKAddressException();
    }

    public boolean isValidCity(String city) throws InvalidUKAddressException {
        boolean isValidCity = userAccountDb.getCityNames().contains(city);
        if (!isValidCity) {
            throw new InvalidUKAddressException();
        }
        return true;
    }
}
