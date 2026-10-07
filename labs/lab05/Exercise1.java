/*
 * Question from the lab manual:
 * Basic: Overload a print or calculation method to accept different parameter lists and test each call.
 */
package lab05;
public class Exercise1 {
    static class Calculator { int add(int a,int b){return a+b;} double add(double a,double b){return a+b;} }
    // Explanation: Overloaded methods have one name but different parameter lists; the compiler selects the matching signature.
    public static void main(String[] args){Calculator c=new Calculator();System.out.println(c.add(2,3));System.out.println(c.add(2.5,3.5));}
}

