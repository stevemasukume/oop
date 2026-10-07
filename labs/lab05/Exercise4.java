/*
 * Question from the lab manual:
 * Intermediate: Write a program whose output differs depending on whether a method or a field is accessed through a superclass reference.
 */
package lab05;
public class Exercise4 {
    static class Parent{String value="parent";String get(){return value;}} static class Child extends Parent{String value="child";String get(){return value;}}
    // Explanation: Fields use the declared reference type, while overridden methods use the object type at runtime.
    public static void main(String[] args){Parent p=new Child();System.out.println(p.value);System.out.println(p.get());}
}

