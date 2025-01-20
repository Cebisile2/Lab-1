/**
 * A class representing a person's name with validation and formatting utilities.
 * Handles first and last names with restrictions on length and content.
 * Names cannot contain the word "admin" (case-insensitive) and must be within
 * specified length limits.
 *
 * @author Cebisile Masombuka
 * @version 1.0
 */
public class Name
{
    private static final int MAX_FIRST_CHAR = 45;
    private static final int MAX_LAST_CHAR  = 45;
    private static final int START_INDEX    = 0;
    private static final int FIRST_CHAR     = 1;

    private final String firstName;
    private final String lastName;

    /**
     * Constructs a new Name object with the specified first and last names.
     *
     * @param firstName The person's first name (must not be null, blank, contain "admin", or exceed 45 characters)
     * @param lastName  The person's last name (must not be null, blank, contain "admin", or exceed 45 characters)
     */
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

    /**
     * Gets the first name.
     *
     * @return The person's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Gets the last name.
     *
     * @return The person's last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Gets the person's initials in uppercase format.
     * Returns the first letter of the first name and last name
     * separated by a period (e.g., "J.D.").
     *
     * @return A string containing the initials in the format "F.L."
     */
    public String getInitials()
    {
        return (firstName.charAt(START_INDEX) + "." + lastName.charAt(START_INDEX)).toUpperCase();
    }

    /**
     * Gets the full name in proper case format.
     * Returns the first and last names with the first letter of each capitalized
     * and the rest in lowercase, separated by a space.
     *
     * @return The full name in proper case format (e.g., "John Doe")
     */
    public String getFullName()
    {
        return firstName.toLowerCase().charAt(START_INDEX) + firstName.substring(FIRST_CHAR).toLowerCase() + " " +
                lastName.toLowerCase().charAt(START_INDEX) + lastName.substring(FIRST_CHAR).toLowerCase();
    }

    /**
     * Gets the full name reversed.
     * Returns the full name (in proper case) with all characters in reverse order.
     *
     * @return The full name reversed (e.g., "eoD nhoJ" for "John Doe")
     */
    public String getReverseName()
    {

        final StringBuilder rv;
        rv = new StringBuilder(getFullName());
        rv.reverse();
        return rv.toString();
    }
}

