/*
 * Question from the lab manual:
 * Basic: Define an interface Flyable with fly() and implement it for Bird and Aeroplane.
 */
package lab06;
public class Exercise2 {
    interface Flyable{void fly();}static class Bird implements Flyable{public void fly(){System.out.println("Bird flies");}}static class Aeroplane implements Flyable{public void fly(){System.out.println("Aeroplane flies");}}
    // Explanation: Bird and Aeroplane share a capability through an interface without needing a common concrete superclass.
    public static void main(String[] args){Flyable[] things={new Bird(),new Aeroplane()};for(Flyable f:things)f.fly();}
}

