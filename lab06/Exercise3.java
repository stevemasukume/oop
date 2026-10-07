/*
 * Question from the lab manual:
 * Intermediate: Build an abstract Account with concrete deposit() and abstract monthlyFee(), then implement two account types.
 */
package lab06;
public class Exercise3 {
    static abstract class Account{double balance;Account(double b){balance=b;}void deposit(double a){balance+=a;}abstract double monthlyFee();}
    static class SavingsAccount extends Account{SavingsAccount(double b){super(b);}double monthlyFee(){return 0;}}
    static class CurrentAccount extends Account{CurrentAccount(double b){super(b);}double monthlyFee(){return 5;}}
    // Explanation: The abstract account provides shared deposit state and behaviour while subclasses define their monthly fee.
    public static void main(String[] args){Account a=new CurrentAccount(100);a.deposit(20);System.out.println(a.balance-a.monthlyFee());}
}

