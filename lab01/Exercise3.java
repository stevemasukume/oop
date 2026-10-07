/*
 * Question from the lab manual:
 * Intermediate: Write a Rectangle class with width, height, and methods area() and perimeter(). Create an array of 5 rectangles and print the one with the largest area.
 */
package lab01;

public class Exercise3 {
    record Rectangle(double width, double height) {
        double area() { return width * height; }
        double perimeter() { return 2 * (width + height); }
    }

    // Explanation: The array is searched with a comparator so the rectangle with the greatest computed area is selected.
    public static void main(String[] args) {
        Rectangle[] rectangles = {new Rectangle(2, 5), new Rectangle(4, 4),
            new Rectangle(3, 7), new Rectangle(1, 9), new Rectangle(6, 2)};
        Rectangle largest = java.util.Arrays.stream(rectangles)
            .max(java.util.Comparator.comparingDouble(Rectangle::area)).orElseThrow();
        System.out.println("Largest area: " + largest.area());
    }
}

