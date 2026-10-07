/*
 * Question from the lab manual:
 * Basic: Create a Student class with private name and marks (0 to 100). Reject invalid marks in the setter and calculate a grade.
 */
package lab03;

public class Exercise1 {
    static class Student {
        private final String name;
        private int marks;
        Student(String name, int marks) { this.name = name; setMarks(marks); }
        void setMarks(int marks) {
            if (marks < 0 || marks > 100) throw new IllegalArgumentException("marks must be 0..100");
            this.marks = marks;
        }
        String getGrade() { return marks >= 80 ? "A" : marks >= 70 ? "B" : marks >= 50 ? "C" : "F"; }
        public String toString() { return name + ": " + marks + " (" + getGrade() + ")"; }
    }

    // Explanation: Private state is changed only through a setter that validates the allowed marks range.
    public static void main(String[] args) {
        System.out.println(new Student("Tariro", 87));
    }
}

