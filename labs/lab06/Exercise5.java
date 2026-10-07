/*
 * Question from the lab manual:
 * Challenge: Resolve two interfaces declaring the same default hello() method with InterfaceName.super.hello().
 */
package lab06;
public class Exercise5 {
    interface First{default void hello(){System.out.println("first");}}interface Second{default void hello(){System.out.println("second");}}
    static class Both implements First,Second{public void hello(){First.super.hello();Second.super.hello();}}
    // Explanation: The implementing class resolves the default-method conflict explicitly by invoking both interface defaults.
    public static void main(String[] args){new Both().hello();}
}

