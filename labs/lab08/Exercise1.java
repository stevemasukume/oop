/*
 * Question from the lab manual:
 * Basic: Store 10 integers in an ArrayList, then print the sum, maximum and the list in reverse order.
 */
package lab08;
import java.util.*;
public class Exercise1 {
    // Explanation: The list API provides order and duplicates; streams calculate aggregates and Collections.reverse changes display order.
    public static void main(String[] args){List<Integer> values=new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));System.out.println(values.stream().mapToInt(Integer::intValue).sum());System.out.println(Collections.max(values));Collections.reverse(values);System.out.println(values);}
}

