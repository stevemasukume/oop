/*
 * Question from the lab manual:
 * Intermediate: Create InvalidAgeException and validateAge(int) for values outside 0 to 120.
 */
package lab07;
public class Exercise3 {
    static class InvalidAgeException extends Exception{InvalidAgeException(String m){super(m);}}
    static void validateAge(int age)throws InvalidAgeException{if(age<0||age>120)throw new InvalidAgeException("Age must be 0..120");}
    // Explanation: A checked custom exception forces callers to acknowledge and handle an invalid age.
    public static void main(String[] args){try{validateAge(130);}catch(InvalidAgeException e){System.out.println(e.getMessage());}}
}

