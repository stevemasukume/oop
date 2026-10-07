/*
 * Question from the lab manual:
 * Exercise: Write a lambda expression implementing a functional interface for a discount strategy.
 */
package lab10;
public class Exercise2 {
    interface Discount{double apply(double price);}
    // Explanation: A lambda supplies the single abstract operation of the functional interface.
    public static void main(String[] args){Discount student=price->price*.9;System.out.println(student.apply(200));}
}

