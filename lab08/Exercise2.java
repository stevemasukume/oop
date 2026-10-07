/*
 * Question from the lab manual:
 * Basic: Remove duplicates from a list of names using a Set.
 */
package lab08;
import java.util.*;
public class Exercise2 {
    // Explanation: A Set keeps only one occurrence of each equal name.
    public static void main(String[] args){Set<String> names=new LinkedHashSet<>(List.of("Rudo","Farai","Rudo","Tariro"));System.out.println(names);}
}

