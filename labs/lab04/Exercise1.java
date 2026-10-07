/*
 * Question from the lab manual:
 * Basic: Create Person (name, age) and Student extends Person (adds course). Print both using an inherited display().
 */
package lab04;
public class Exercise1 {
    static class Person { final String name; final int age; Person(String n, int a) { name=n; age=a; } void display(){System.out.println(name+", "+age);} }
    static class Student extends Person { final String course; Student(String n,int a,String c){super(n,a);course=c;} }
    // Explanation: Student inherits the common Person state and display behaviour, then adds course-specific state.
    public static void main(String[] args){new Student("Anesu",20,"OOP").display();}
}

