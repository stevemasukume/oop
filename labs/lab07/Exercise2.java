/*
 * Question from the lab manual:
 * Basic: Write a method that accesses an array element and catches ArrayIndexOutOfBoundsException.
 */
package lab07;
public class Exercise2 {
    static int element(int[] values,int index){return values[index];}
    // Explanation: The array access is isolated in a method and its specific runtime exception is caught by the caller.
    public static void main(String[] args){try{System.out.println(element(new int[]{1,2},5));}catch(ArrayIndexOutOfBoundsException e){System.out.println("Bad index");}}
}

