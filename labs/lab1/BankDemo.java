/*
 * Questions 4 and 5:
 * Store different account types in one List<Account> and process them
 * through Account references only. This demonstrates polymorphism:
 * Java automatically calls the correct subclass implementation.
 *
 * The demo includes:
 * - A rejected savings withdrawal because it would cross the minimum balance.
 * - A current-account withdrawal that enters an overdraft within its limit.
 */
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("             BANK ACCOUNT DEMO");
        System.out.println("========================================");

        List<Account> accounts = List.of(
            new SavingsAccount("S-1001", 1000.00, 500.00),
            new CurrentAccount("C-2001", 1000.00, 300.00),
            new SavingsAccount("S-1002", 1500.00, 1000.00)
        );
        double[] withdrawalAmounts = {600.00, 1200.00, 400.00};

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.printf(
                "%n----------------------------------------%n"
                    + "Account type: %s%n"
                    + "Account number: %s%n"
                    + "Starting balance: $%.2f%n"
                    + "Requested withdrawal: $%.2f%n",
                account.getClass().getSimpleName(),
                account.getAccountNumber(),
                account.getBalance(),
                withdrawalAmounts[i]
            );

            account.withdraw(withdrawalAmounts[i]);
            account.endOfMonth();
            System.out.printf("Ending balance: $%.2f%n", account.getBalance());
        }

        System.out.println("----------------------------------------");
        System.out.println("Demo complete: all operations used Account references.");
    }
}
