/*
 * Question from the lab manual:
 * Intermediate: Read a paragraph and print the frequency of each word using a Map.
 */
package lab08;
import java.util.*;
public class Exercise4 {
    // Explanation: A Map records each word as a key and increments its frequency as the paragraph is processed.
    public static void main(String[] args){String text="java is fun and java is useful";Map<String,Long> count=Arrays.stream(text.split(" ")).collect(java.util.stream.Collectors.groupingBy(x->x,java.util.stream.Collectors.counting()));System.out.println(count);}
}

