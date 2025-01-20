/**
 * Represents a person with a name, date of birth, and optionally a date of death.
 * Provides methods to retrieve details about the person, including their name,
 * birthdate, and death status.
 *
 * @author Cebisile Masombuka
 * @version 1.0
 */
public class Person
{
    private final Name name;
    private final Date dateOfBirth;
    private Date       dateOfDeath;

    /**
     * Constructs a Person object with the specified name, date of birth, and date of death.
     *
     * @param name        the name of the person.
     * @param dateOfBirth the date of birth of the person.
     * @param dateOfDeath the date of death of the person(nullable).
     */
    Person(final Name name,
           final Date dateOfBirth,
           final Date dateOfDeath)
    {

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return the name of the person.
     */
    Name getName()
    {
        return name;
    }

    /**
     * Retrieves the date of birth of the person.
     *
     * @return the date of birth.
     */
    Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Retrieves the date of death of the person.
     *
     * @return the date of death, or null if the person is alive.
     */
    Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    public String getDetails()
    {
        if(isAlive())
        {
            return getName().getFullName() + " (alive) was born on " +
                    getDateOfBirth().getDayOfWeek() + ", " +
                    getDateOfBirth().getMonth() + " " +
                    getDateOfBirth().getDay() + ", " +
                    getDateOfBirth().getYear() + "!";
        }
        else
        {
            return getName().getFullName() + " (died " +
                    getDateOfDeath().getDayOfWeek() + ", " +
                    getDateOfDeath().getMonth() + " " +
                    getDateOfDeath().getDay() + ", " +
                    getDateOfDeath().getYear() + ")" +
                    " was born on " +
                    getDateOfBirth().getDayOfWeek() + ", " +
                    getDateOfBirth().getMonth() + " " +
                    getDateOfBirth().getDay() + ", " +
                    getDateOfBirth().getYear() + "!";
        }
    }

    /**
     * Checks if the person is alive.
     *
     * @return true if the person is alive, false otherwise.
     */
    public boolean isAlive()
    {
        return dateOfDeath == null;
    }
}