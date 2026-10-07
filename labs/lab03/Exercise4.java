/*
 * Question from the lab manual:
 * Challenge: Build a Temperature class that stores kelvin internally but offers Celsius and Fahrenheit accessors.
 */
package lab03;

public class Exercise4 {
    static final class Temperature {
        private final double kelvin;
        Temperature(double kelvin) {
            if (kelvin < 0) throw new IllegalArgumentException("below absolute zero");
            this.kelvin = kelvin;
        }
        double celsius() { return kelvin - 273.15; }
        double fahrenheit() { return celsius() * 9 / 5 + 32; }
    }

    // Explanation: The object stores one internal unit and converts it at the public boundary, keeping callers independent of representation.
    public static void main(String[] args) {
        Temperature temperature = new Temperature(300);
        System.out.println(temperature.celsius() + " C");
        System.out.println(temperature.fahrenheit() + " F");
    }
}

