/*
 * Question from the lab manual:
 * Intermediate: Build Vehicle, Car and ElectricCar (multilevel). Trace and print the order of constructor calls.
 */
package lab04;
public class Exercise3 {
    static class Vehicle { Vehicle(){System.out.println("Vehicle");} }
    static class Car extends Vehicle { Car(){System.out.println("Car");} }
    static class ElectricCar extends Car { ElectricCar(){System.out.println("ElectricCar");} }
    // Explanation: Constructors run from the superclass toward the subclass, which establishes inherited state first.
    public static void main(String[] args){new ElectricCar();}
}

