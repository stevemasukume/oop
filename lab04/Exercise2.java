/*
 * Question from the lab manual:
 * Basic: Add a Teacher subclass and show that Student and Teacher share the Person code.
 */
package lab04;
public class Exercise2 {
    static class Person { void display(){System.out.println("Person behaviour");} }
    static class Teacher extends Person { }
    static class Student extends Person { }
    // Explanation: Both subclasses inherit one implementation, demonstrating shared behaviour through a superclass reference.
    public static void main(String[] args){Person[] people={new Student(),new Teacher()};for(Person p:people)p.display();}
}

