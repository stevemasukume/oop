/*
 * Question from the lab manual:
 * Basic: Create a Car class with fields brand, year and mileage, and a method display(). Create three cars and print them.
 */
package lab01;

public class Exercise1 {
    static class Car {
        String brand;
        int year;
        double mileage;

        Car(String brand, int year, double mileage) {
            this.brand = brand;
            this.year = year;
            this.mileage = mileage;
        }

        void display() {
            System.out.printf("%s (%d), %.0f km%n", brand, year, mileage);
        }
    }

    // Explanation: The main method creates objects and calls their behaviour; fields hold state and methods provide operations.
    public static void main(String[] args) {
        new Car("Toyota", 2020, 45000).display();
        new Car("Mazda", 2010, 120000).display();
        new Car("Ford", 2022, 18000).display();
    }
}

