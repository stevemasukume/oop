/*
 * Question 2:
 * Create a SavingsAccount that protects a fixed minimum balance and
 * earns interest at the end of each month.
 */
public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.02;
    private final double minimumBalance;

    public SavingsAccount(
        String accountNumber,
        double initialBalance,
        double minimumBalance
    ) {
        super(accountNumber, initialBalance);
        if (minimumBalance < 0) {
            throw new IllegalArgumentException("Minimum balance must not be negative.");
        }
        if (initialBalance < minimumBalance) {
            throw new IllegalArgumentException(
                "Initial balance must not be below the minimum balance."
            );
        }

        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        // A savings withdrawal is allowed only when the minimum balance
        // remains protected after the withdrawal.
        if (amount <= 0) {
            System.out.printf(
                "[REJECTED] Savings withdrawal for %s: amount must be positive.%n",
                accountNumber
            );
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.printf(
                "[REJECTED] Savings withdrawal for %s: "
                    + "balance cannot fall below %.2f.%n",
                accountNumber,
                minimumBalance
            );
            return;
        }

        balance -= amount;
        System.out.printf(
            "[SUCCESS] Withdrew $%.2f from savings account %s.%n",
            amount,
            accountNumber
        );
    }

    @Override
    public void endOfMonth() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.printf(
            "[MONTH-END] Savings account %s earned $%.2f interest.%n",
            accountNumber,
            interest
        );
    }
}
