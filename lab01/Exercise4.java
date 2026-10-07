/*
 * Question from the lab manual:
 * Intermediate: Predict, then run, a program that assigns Rectangle r2 = r1;, changes r2.width, and prints r1.width. Explain the aliasing result.
 */
package lab01;

public class Exercise4 {
    static class Rectangle {
        double width;
        Rectangle(double width) { this.width = width; }
    }

    // Explanation: Both variables refer to the same object, so changing the alias changes the original object.
    public static void main(String[] args) {
        Rectangle first = new Rectangle(4);
        Rectangle second = first;
        second.width = 9;
        System.out.println("first.width = " + first.width);
    }
}
