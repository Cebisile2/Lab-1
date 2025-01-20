import java.util.Arrays;
import java.util.List;

/**
 * Represents a bank client, extending the Person class. Each client has a unique ID and a sign-up date.
 * This class provides methods to retrieve client details and validate client data during initialization.
 *
 * @author Cebisile Masombuka
 * @version 1.0
 */
public class BankClient extends Person
{
    private static final List<Integer> validClientIDLen = Arrays.asList(6, 7);
    private final String clientID;
    private final Date signUpDate;

    /**
     * Constructs a BankClient object with the specified name, date of birth, date of death, sign-up date, and client ID.
     *
     * @param name      the name of the client.
     * @param dateBorn  the date of birth of the client.
     * @param dateDied  the date of death of the client.
     * @param signUpDate the date when the client signed up with the bank.
     * @param clientID  the unique identifier for the client.
     */
    public BankClient(final Name name,
                      final Date dateBorn,
                      final Date dateDied,
                      final Date signUpDate,
                      final String clientID)
    {
        super(name, dateBorn, dateDied);

        if(!validClientIDLen.contains(clientID.length()))
        {
            throw new IllegalArgumentException(String.format("Client Id should be %d or %d characters: %s",
                    validClientIDLen.getFirst(), validClientIDLen.getLast(), clientID));
        }
        this.signUpDate = signUpDate;
        this.clientID = clientID;
    }

    /**
     * Retrieves the date when the client signed up with the bank.
     *
     * @return the sign-up date of the client.
     */
    public Date getSignUpDate()
    {
        return signUpDate;
    }

    /**
     * Retrieves the detailed information of the bank client.
     * Includes the client's name, ID, and the day of the week, month, and year they signed up.
     *
     * @return a string representing the client's details.
     */
    @Override
    public String getDetails()
    {
        return getName().getFullName() + " client #" + clientID + " (alive) " +
                "joined the bank on " + this.signUpDate.getDayOfWeek().toLowerCase()+
                "," + this.signUpDate.getMonth() + " " + this.signUpDate.getDay() +
                "," + this.signUpDate.getYear();
    }
}
