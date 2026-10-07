/*
 * Question from the lab manual:
 * Intermediate: Modify BankAccount so withdraw throws InsufficientFundsException instead of returning false.
 */
package lab07;
public class Exercise4 {
    static class InsufficientFundsException extends Exception{InsufficientFundsException(){super("Insufficient funds");}}
    static class BankAccount{double balance=50;void withdraw(double a)throws InsufficientFundsException{if(a>balance)throw new InsufficientFundsException();balance-=a;}}
    // Explanation: The withdraw method rejects an unsafe operation by throwing a meaningful checked exception.
    public static void main(String[] args){try{new BankAccount().withdraw(60);}catch(InsufficientFundsException e){System.out.println(e.getMessage());}}
}

