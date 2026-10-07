/*
 * Question from the lab manual:
 * Basic: Create a record Student(String name, int age), compare two equal records and read a component.
 */
package lab09;
public class Exercise2 {
    record Student(String name,int age){}
    // Explanation: Records generate value-based equals, hashCode, toString and accessors automatically.
    public static void main(String[] args){Student a=new Student("Tariro",21),b=new Student("Tariro",21);System.out.println(a+" equal? "+a.equals(b)+" name="+a.name());}
}

