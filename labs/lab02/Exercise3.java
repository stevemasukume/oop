/*
 * Question from the lab manual:
 * Challenge: Implement a Temperature class with static factory methods fromCelsius(double) and fromFahrenheit(double) and a private constructor.
 */
package lab02;

public class Exercise3 {
    static final class Temperature {
        private final double celsius;
        private Temperature(double celsius) { this.celsius = celsius; }
        static Temperature fromCelsius(double value) { return new Temperature(value); }
        static Temperature fromFahrenheit(double value) {
            return new Temperature((value - 32) * 5 / 9);
        }
        public String toString() { return celsius + " C"; }
    }

    // Explanation: A private constructor forces callers to use named factory methods that clearly describe the input unit.
    public static void main(String[] args) {
        System.out.println(Temperature.fromCelsius(25));
        System.out.println(Temperature.fromFahrenheit(77));
    }
}

