public class Name
{
    private static final int MAX_FIRST_CHAR = 45;
    private static final int MAX_LAST_CHAR  = 45;
    private static final int START_INDEX    = 0;
    private static final int FIRST_CHAR     = 1;

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
        return (firstName.charAt(START_INDEX) + "." + lastName.charAt(START_INDEX)).toUpperCase();
    }

    public String getFullName()
    {
        return firstName.toLowerCase().charAt(START_INDEX) + firstName.substring(FIRST_CHAR).toLowerCase() + " " +
                lastName.toLowerCase().charAt(START_INDEX) + lastName.substring(FIRST_CHAR).toLowerCase();
    }

    public String getReverseName()
    {

        final StringBuilder rv;
        rv = new StringBuilder(getFullName());
        rv.reverse();
        return rv.toString();
    }
}

