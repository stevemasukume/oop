/*
 * Question from the lab manual:
 * Intermediate: Create an ImmutablePerson class with final fields and no setters.
 */
package lab03;

public class Exercise3 {
    static final class ImmutablePerson {
        private final String name;
        private final int age;
        ImmutablePerson(String name, int age) { this.name = name; this.age = age; }
        public String toString() { return name + " (" + age + ")"; }
    }

    // Explanation: Final fields and the absence of setters prevent the person from changing after construction.
    public static void main(String[] args) {
        System.out.println(new ImmutablePerson("Rudo", 21));
    }
}

