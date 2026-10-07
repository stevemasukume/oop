/*
 * Question 3:
 * Create a CurrentAccount that allows an overdraft up to a fixed limit
 * and charges a maintenance fee at the end of each month.
 */
public class CurrentAccount extends Account {
    private static final double MONTHLY_FEE = 5.00;
    private final double overdraftLimit;

    public CurrentAccount(
        String accountNumber,
        double initialBalance,
        double overdraftLimit
    ) {
        super(accountNumber, initialBalance);
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit must not be negative.");
        }

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        // The balance may become negative, but never lower than the
        // negative overdraft limit.
        if (amount <= 0) {
            System.out.printf(
                "[REJECTED] Current withdrawal for %s: amount must be positive.%n",
                accountNumber
            );
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.printf(
                "[REJECTED] Current withdrawal for %s: "
                    + "overdraft limit of %.2f would be exceeded.%n",
                accountNumber,
                overdraftLimit
            );
            return;
        }

        balance -= amount;
        System.out.printf(
            "[SUCCESS] Withdrew $%.2f from current account %s.%n",
            amount,
            accountNumber
        );
    }

    @Override
    public void endOfMonth() {
        balance -= MONTHLY_FEE;
        System.out.printf(
            "[MONTH-END] Current account %s charged a $%.2f maintenance fee.%n",
            accountNumber,
            MONTHLY_FEE
        );
    }
}
