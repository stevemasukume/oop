/*
 * Question from the lab manual:
 * Challenge: Predict and verify output from a return inside try and a statement inside finally.
 */
package lab07;
public class Exercise5 {
    static int result(){try{return 1;}finally{System.out.println("finally executes");}}
    // Explanation: finally runs before the method returns, so cleanup or logging is guaranteed.
    public static void main(String[] args){System.out.println("result="+result());}
}

