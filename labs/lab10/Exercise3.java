/*
 * Question from the lab manual:
 * Exercise: Use a method reference and a stream to transform and sort names.
 */
package lab10;
import java.util.*;
public class Exercise3 {
    // Explanation: The method reference reuses String.toUpperCase while the stream performs transformation and sorting.
    public static void main(String[] args){List<String> names=List.of("Tariro","Farai","Rudo");names.stream().map(String::toUpperCase).sorted().forEach(System.out::println);}
}

