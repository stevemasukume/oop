/*
 * Question from the lab manual:
 * Exercise: Demonstrate a static counter shared by all instances of a class.
 */
package lab02;

public class Exercise5 {
    static class Counter {
        static int count;
        Counter() { count++; }
    }

    // Explanation: The static field is shared by every Counter object, so each constructor increments the same value.
    public static void main(String[] args) {
        new Counter();
        new Counter();
        System.out.println("Objects created: " + Counter.count);
    }
}

