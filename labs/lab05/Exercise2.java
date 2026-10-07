/*
 * Question from the lab manual:
 * Basic: Create Animal with sound() and subclasses Cat, Cow and Duck. Store them in an Animal[] and loop.
 */
package lab05;
public class Exercise2 {
    interface Animal{void sound();} static class Cat implements Animal{public void sound(){System.out.println("meow");}}
    static class Cow implements Animal{public void sound(){System.out.println("moo");}} static class Duck implements Animal{public void sound(){System.out.println("quack");}}
    // Explanation: The array type is Animal, but dynamic dispatch invokes each object implementation of sound().
    public static void main(String[] args){Animal[] animals={new Cat(),new Cow(),new Duck()};for(Animal a:animals)a.sound();}
}

