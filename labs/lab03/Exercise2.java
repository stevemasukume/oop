/*
 * Question from the lab manual:
 * Exercise: Encapsulate a bank account balance and expose validated deposit behaviour through methods.
 */
package lab03;

public class Exercise2 {
    static class BankAccount {
        private double balance;
        BankAccount(double balance) { this.balance = balance; }
        void deposit(double amount) { if (amount <= 0) throw new IllegalArgumentException("positive amount required"); balance += amount; }
        double getBalance() { return balance; }
    }

    // Explanation: The balance remains private and can only be changed through the validated deposit operation.
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        System.out.println(account.getBalance());
    }
}

