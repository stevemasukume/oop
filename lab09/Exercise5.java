/*
 * Question from the lab manual:
 * Exercise: Demonstrate nested types, including a static nested helper and an inner class.
 */
package lab09;
public class Exercise5 {
    static class Nested{static class Helper{static String text(){return "static nested";}}class Inner{String text(){return "inner";}}}
    // Explanation: A static nested class does not need an outer object; an inner class does and can access its instance.
    public static void main(String[] args){System.out.println(Nested.Helper.text());System.out.println(new Nested().new Inner().text());}
}

