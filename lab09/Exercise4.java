/*
 * Question from the lab manual:
 * Intermediate: Write a LinkedList class with a private static nested Node class and an inner Iterator class.
 */
package lab09;
import java.util.*;
public class Exercise4 {
    static class LinkedList<T> implements Iterable<T>{static class Node<T>{T value;Node<T> next;Node(T v){value=v;}}Node<T> head;void add(T v){Node<T> n=new Node<>(v);n.next=head;head=n;}public Iterator<T> iterator(){return new Iterator<>(){Node<T> current=head;public boolean hasNext(){return current!=null;}public T next(){T v=current.value;current=current.next;return v;}};}}
    // Explanation: The static Node type stores links without an outer-list reference, while the iterator traverses the list state.
    public static void main(String[] args){LinkedList<Integer> list=new LinkedList<>();list.add(1);list.add(2);for(int x:list)System.out.println(x);}
}

