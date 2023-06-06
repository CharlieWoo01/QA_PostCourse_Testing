package qa;

public class Address
{
    IUserAccountDb userAccountDb;
    
    public String number;
    public String addressLine;
    public String postCode;
    public String city;

    public Address(String number, String addressLine, 
    		String postCode, String city,
    		IUserAccountDb userAccountDb)
    {

        this.userAccountDb = userAccountDb;
        this.number = number;
        this.addressLine = addressLine;
        if (isValidCity(city))
            this.city = city;
        else
            throw new IllegalArgumentException();

        if (Utils.isValidUKPostCode(postCode))
            this.postCode = postCode;
        else
            throw new IllegalArgumentException();
    }

    public boolean isValidCity(String city)
    {
        return userAccountDb.getCityNames().contains(city);
    }
}
