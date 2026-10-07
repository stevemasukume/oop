/*
 * Question 1:
 * Create an abstract Account class that contains the common account
 * behaviour: account details, deposits, balance tracking, and abstract
 * withdrawal and month-end operations.
 */
public abstract class Account {
    // Protected fields are available to the account subclasses.
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        // Validate values shared by every account type.
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number must not be blank.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must not be negative.");
        }

        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        // Deposits must increase the balance by a positive amount only.
        if (amount <= 0) {
            System.out.printf(
                "[REJECTED] Deposit for account %s: amount must be positive.%n",
                accountNumber
            );
            return;
        }

        balance += amount;
        System.out.printf(
            "[SUCCESS] Deposited $%.2f into account %s.%n",
            amount,
            accountNumber
        );
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Each account type applies its own withdrawal rules.
    public abstract void withdraw(double amount);

    // Each account type applies its own month-end processing.
    public abstract void endOfMonth();
}
