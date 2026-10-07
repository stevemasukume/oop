/*
 * Question from the lab manual:
 * Intermediate: Extend the employee hierarchy with Intern and compute total payroll for a mixed array.
 */
package lab05;
public class Exercise3 {
    static class Employee{double pay(){return 1000;}} static class Intern extends Employee{ }
    static class Manager extends Employee{double pay(){return 2000;}}
    // Explanation: The payroll loop depends only on Employee, so adding Intern does not require changing the loop.
    public static void main(String[] args){Employee[] staff={new Intern(),new Manager()};double total=0;for(Employee e:staff)total+=e.pay();System.out.println(total);}
}

