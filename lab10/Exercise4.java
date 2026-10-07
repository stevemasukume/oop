/*
 * Question from the lab manual:
 * Exercise: Use streams to parse student records and filter students by GPA.
 */
package lab10;
import java.util.*;
public class Exercise4 {
    // Explanation: The stream maps CSV fields, converts GPA text to a number, and filters qualifying records.
    public static void main(String[] args){List<String> lines=List.of("Tariro,101,3.8","Farai,102,3.1","Rudo,103,3.9");lines.stream().map(x->x.split(",")).filter(x->Double.parseDouble(x[2])>=3.5).forEach(x->System.out.println(x[0]));}
}

