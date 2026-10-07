/*
 * Question from the lab manual:
 * Intermediate: Write an Employee class with an auto-incrementing employeeId, three overloaded constructors and a copy constructor.
 */
package lab02;

public class Exercise2 {
    static class Employee {
        private static int nextId = 1;
        final int id = nextId++;
        final String name;
        final double salary;
        Employee() { this("Unknown", 0); }
        Employee(String name) { this(name, 0); }
        Employee(String name, double salary) { this.name = name; this.salary = salary; }
        Employee(Employee other) { this(other.name, other.salary); }
        public String toString() { return id + ": " + name + " ($" + salary + ")"; }
    }

    // Explanation: A static counter belongs to the class, while each Employee receives its own id and state.
    public static void main(String[] args) {
        System.out.println(new Employee("Tariro", 2500));
        System.out.println(new Employee(new Employee("Farai", 3000)));
    }
}

