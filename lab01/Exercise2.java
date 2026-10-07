/*
 * Question from the lab manual:
 * Basic: Add a method isAntique() to Car that returns true when the car is more than 25 years old.
 */
package lab01;

public class Exercise2 {
    static class Car {
        final int year;
        Car(int year) { this.year = year; }
        boolean isAntique() { return java.time.Year.now().getValue() - year > 25; }
    }

    // Explanation: This method checks the car age against the 25-year antique threshold.
    public static void main(String[] args) {
        System.out.println("1990 antique? " + new Car(1990).isAntique());
        System.out.println("2020 antique? " + new Car(2020).isAntique());
    }
}