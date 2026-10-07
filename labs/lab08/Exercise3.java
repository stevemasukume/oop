/*
 * Question from the lab manual:
 * Intermediate: Write a generic Stack<T> backed by an ArrayList<T> with push, pop, peek and isEmpty.
 */
package lab08;
import java.util.*;
public class Exercise3 {
    static class Stack<T>{List<T> values=new ArrayList<>();void push(T v){values.add(v);}T pop(){return values.remove(values.size()-1);}T peek(){return values.get(values.size()-1);}boolean isEmpty(){return values.isEmpty();}}
    // Explanation: The generic type parameter allows the same stack implementation to work safely with different reference types.
    public static void main(String[] args){Stack<String> s=new Stack<>();s.push("A");s.push("B");System.out.println(s.peek()+", "+s.pop());}
}

