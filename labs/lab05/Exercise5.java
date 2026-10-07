/*
 * Question from the lab manual:
 * Challenge: Implement PaymentProcessor.pay(Payment p) for CardPayment and MobileMoneyPayment using polymorphism.
 */
package lab05;
public class Exercise5 {
    interface Payment{void process();} static class CardPayment implements Payment{public void process(){System.out.println("Card processed");}}
    static class MobileMoneyPayment implements Payment{public void process(){System.out.println("Mobile money processed");}}
    // Explanation: The Payment interface defines the common operation, allowing the processor to work with multiple payment implementations.
    public static void main(String[] args){Payment[] payments={new CardPayment(),new MobileMoneyPayment()};for(Payment p:payments)p.process();}
}

