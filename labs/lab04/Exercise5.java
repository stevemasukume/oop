/*
 * Question from the lab manual:
 * Challenge: Refactor a Stack extends ArrayList design into a Stack that contains an ArrayList.
 */
package lab04;
import java.util.ArrayList;
public class Exercise5 {
    static class Stack<T>{private final ArrayList<T> values=new ArrayList<>();void push(T v){values.add(v);}T pop(){return values.remove(values.size()-1);}}
    // Explanation: Composition keeps the backing list private, exposing only stack operations instead of every ArrayList operation.
    public static void main(String[] args){Stack<Integer> stack=new Stack<>();stack.push(1);stack.push(2);System.out.println(stack.pop());}
}

