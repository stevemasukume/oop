/*
 * Question from the lab manual:
 * Basic: Read two integers and divide them, handling non-numeric input and division by zero.
 */
package lab07;
import java.util.*;
public class Exercise1 {
    // Explanation: The multi-catch handles the two expected input failures in one consistent error path.
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner("10 0")) {
            System.out.println(scanner.nextInt() / scanner.nextInt());
        } catch (ArithmeticException | InputMismatchException e) {
            System.out.println("Invalid division input: " + e.getClass().getSimpleName());
        }
    }
}
