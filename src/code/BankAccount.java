public class BankAccount
{
    private final BankClient client;
    private double           balanceUsd;
    private final int        pin;
    private final String     accountNumber;

    BankAccount(final BankClient client,
                final int pin,
                final String accountNumber,
                final double balanceUsd)
    {

        if(accountNumber.length() != 6 && accountNumber.length() != 7 )
        {
            throw new IllegalArgumentException("account number should be 6 or 7 characters: " + accountNumber);
        }
        this.client = client;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.balanceUsd = balanceUsd;
    }

    public BankClient getClient()
    {
        return client;
    }

    public double getBalanceUsd()
    {
        return balanceUsd;
    }

    public int getPin()
    {
        return pin;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void deposit()
    {

    }
    
    public void withdraw(final double amountUsd)
    {
        if(amountUsd > balanceUsd)
        {
            throw new IllegalArgumentException("Insufficient funds. Balance Available: " + balanceUsd);
        }

        balanceUsd -= amountUsd;
    }

    public void withdraw(final double amountUsd, final int pinToMatch)
    {
        if(pinToMatch != pin)
        {
            throw new IllegalArgumentException("Invalid pin entered. ABORTING!");
        }
        balanceUsd -= amountUsd;

    }

    public String detDetails()
    {
        return this.client.getName().getFullName() + "had $" +
                getBalanceUsd() + "USD" + "in account " +
                "#" + getAccountNumber() + "which was opened on " +
                this.client.getSignUpDate().getDayOfWeek() +
                this.client.getSignUpDate().getMonth() +
                this.client.getSignUpDate().getDay() +
                this.client.getSignUpDate().getYear() +
                " and closed " + this.client.getSignUpDate().getDayOfWeek() +
                this.client.getSignUpDate().getMonth() + this.client.getSignUpDate().getDay() +
                this.client.getSignUpDate().getYear();

    }

}
