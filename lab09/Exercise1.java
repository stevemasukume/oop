/*
 * Question from the lab manual:
 * Basic: Define an enum Level { LOW, MEDIUM, HIGH } and a switch that prints advice for each.
 */
package lab09;
public class Exercise1 {
    enum Level{LOW,MEDIUM,HIGH}
    static String advice(Level l){return switch(l){case LOW->"Proceed";case MEDIUM->"Be careful";case HIGH->"Stop";};}
    // Explanation: The enum restricts values to known constants and the switch provides advice for every constant.
    public static void main(String[] args){for(Level l:Level.values())System.out.println(l+": "+advice(l));}
}

