/*
 * Question from the lab manual:
 * Intermediate: Make Student implement Comparable<Student> sorted by name.
 */
package lab06;
import java.util.*;
public class Exercise4 {
    static class Student implements Comparable<Student>{String name;int marks;Student(String n,int m){name=n;marks=m;}public int compareTo(Student s){return name.compareTo(s.name);}public String toString(){return name;}}
    // Explanation: Comparable supplies a natural ordering, allowing Collections.sort to compare students by name.
    public static void main(String[] args){List<Student> s=new ArrayList<>(List.of(new Student("Zoe",70),new Student("Anesu",90)));Collections.sort(s);System.out.println(s);}
}

