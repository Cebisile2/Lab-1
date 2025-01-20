public class Person
{
    private final Name name;
    private final Date dateOfBirth;
    private Date       dateOfDeath;

    Person(final Name name,
           final Date dateOfBirth,
           final Date dateOfDeath)
    {

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    Name getName()
    {
        return name;
    }

    Date getDateOfBirth()
    {
        return dateOfBirth;
    }

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

    public boolean isAlive()
    {
        return dateOfDeath == null;
    }
}