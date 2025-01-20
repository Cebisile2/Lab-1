/**
 * A class to represent a bank account for a client.
 *
 * @author Annah Masombuka
 * @version 1.0
 */
public class BankAccount
{
    private static final int MIN_VALID_AMOUNT = 0;

    private final BankClient client;
    private double           balanceUsd;
    private final int        pin;
    private final String     accountNumber;

    /**
     * Creates a new bank account with the specified client, pin, account number, and initial balance.
     *
     * @param client the bank client associated with this account
     * @param pin the PIN required to access and withdraw funds from this account
     * @param accountNumber the account number for this account
     * @param balanceUsd the initial balance of the account in USD
     */
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

    /**
     * Returns the bank client associated with this account.
     *
     * @return the bank client associated with this account
     */
    public BankClient getClient()
    {
        return client;
    }

    /**
     * Returns the current balance of the account in USD.
     *
     * @return the current balance of the account in USD
     */
    public double getBalanceUsd()
    {
        return balanceUsd;
    }

    /**
     * Returns the PIN required to access and withdraw funds from this account.
     *
     * @return the PIN required to access and withdraw funds from this account
     */
    public int getPin()
    {
        return pin;
    }

    /**
     * Returns the account number for this account.
     *
     * @return the account number for this account
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Deposits the specified amount of money into this account.
     *
     * @param amountUsd the amount of money to deposit in USD. Must be positive.
     */
    public void deposit(final double amountUsd)
    {
        if (amountUsd <= MIN_VALID_AMOUNT)
        {
            throw new IllegalArgumentException("Deposit amount must be positive: " + amountUsd);
        }
        balanceUsd += amountUsd;
    }

    /**
     * Withdraws the specified amount of money from this account.
     *
     * @param amountUsd the amount of money to withdraw in USD
     */
    public void withdraw(final double amountUsd)
    {
        if(amountUsd > balanceUsd)
        {
            throw new IllegalArgumentException("Insufficient funds. Balance Available: " + balanceUsd);
        }

        balanceUsd -= amountUsd;
    }

    /**
     * Withdraws the specified amount of money from this account if the provided PIN matches the account's PIN.
     *
     * @param amountUsd the amount of money to withdraw in USD
     * @param pinToMatch the PIN to use to withdraw funds
     */
    public void withdraw(final double amountUsd, final int pinToMatch)
    {
        if(pinToMatch != pin)
        {
            throw new IllegalArgumentException("Invalid pin entered. ABORTING!");
        }
        balanceUsd -= amountUsd;

    }

    /**
     * Returns a string representation of the account details, including the client name, balance, account number,
     * and signup date.
     *
     * @return a string representation
     */
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
