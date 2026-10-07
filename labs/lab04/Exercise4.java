/*
 * Question from the lab manual:
 * Intermediate: Explain with code why a subclass must call a superclass constructor when the superclass only has Animal(String name).
 */
package lab04;
public class Exercise4 {
    static class Animal { Animal(String name){System.out.println(name);} }
    static class Dog extends Animal { Dog(){super("Dog");} }
    // Explanation: Because Animal has no no-argument constructor, Dog explicitly calls the available superclass constructor with super().
    public static void main(String[] args){new Dog();}
}

