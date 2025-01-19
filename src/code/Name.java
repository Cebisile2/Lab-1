public class Name
{
    private static final int MAX_FIRST_CHAR = 45;
    private static final int MAX_LAST_CHAR  = 45;

    private final String firstName;
    private final String lastName;

    public Name(final String firstName,
                final String lastName)
    {
        if(firstName == null)
        {
            throw new NullPointerException("Invalid first name: null");
        }
        if(firstName.isBlank() || firstName.length() > MAX_FIRST_CHAR || firstName.toLowerCase().contains("admin"))
        {
            throw new IllegalArgumentException("Invalid first name: " + firstName);
        }

        if(lastName == null)
        {
            throw new NullPointerException("Invalid first name: null");
        }
        if(lastName.isBlank() || lastName.length() > MAX_LAST_CHAR || lastName.toLowerCase().contains("admin"))
        {
            throw new IllegalArgumentException("Invalid last name: " + lastName);
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getInitials()
    {
        return (firstName.charAt(0) + "." + lastName.charAt(0)).toUpperCase();
    }

    public String getFullName()
    {
        return firstName +" " + lastName;
    }

    public String getReverseName()
    {

        final StringBuilder rv;
        rv = new StringBuilder(getFullName());
        rv.reverse();
        return rv.toString();

    }

}

