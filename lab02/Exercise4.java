/*
 * Question from the lab manual:
 * Exercise: Demonstrate the order in which static initializers, instance initializers and constructors run.
 */
package lab02;

public class Exercise4 {
    static class InitOrder {
        static { System.out.println("static block"); }
        { System.out.println("instance block"); }
        InitOrder() { System.out.println("constructor"); }
    }

    // Explanation: Static initialization runs once; instance initialization and the constructor run for every new object.
    public static void main(String[] args) {
        new InitOrder();
        new InitOrder();
    }
}

