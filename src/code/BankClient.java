import java.util.Arrays;
import java.util.List;

public class BankClient extends Person
{
    private static final List<Integer> validClientIDLen = Arrays.asList(6, 7);
    private final String clientID;
    private final Date signUpDate;

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

    public Date getSignUpDate()
    {
        return signUpDate;
    }

    @Override
    public String getDetails()
    {
        return getName().getFullName() + " client #" + clientID + " (alive) " +
                "joined the bank on " + this.signUpDate.getDayOfWeek().toLowerCase()+
                "," + this.signUpDate.getMonth() + " " + this.signUpDate.getDay() +
                "," + this.signUpDate.getYear();
    }

    public static void main(final String[] args)
    {
        final BankClient c1;
        final Name name;
        final Date date;
        final Date dateOfBirth;
        final Date dateOfDeath;
        final Date signeUp;

        signeUp = new Date(2020,9,3);
        dateOfDeath = new Date(1955,4,1955);
        dateOfBirth = new Date(1879,3,14);
        date = new Date(1990,1,1);
        name = new Name("Tiger", "Woods");
        c1 = new BankClient(name,dateOfBirth,null,signeUp,"123456");
        System.out.println(c1.getDetails());
    }
}
