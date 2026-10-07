/*
 * Question from the lab manual:
 * Basic: Create a Circle class with a constructor taking radius, and a no-argument constructor defaulting the radius to 1.0.
 */
package lab02;

public class Exercise1 {
    static class Circle {
        final double radius;
        Circle() { this(1.0); }
        Circle(double radius) { this.radius = radius; }
        double area() { return Math.PI * radius * radius; }
    }

    // Explanation: The no-argument constructor delegates to the radius constructor and supplies the required default.
    public static void main(String[] args) {
        System.out.println(new Circle().area());
        System.out.println(new Circle(3).area());
    }
}

