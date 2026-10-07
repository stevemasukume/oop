import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Runnable solutions for the practical exercises in Labs 1-10.
 * Each lab method is deliberately small so students can trace it in a debugger.
 */
public class LabExercisesRunner {
    public static void main(String[] args) throws Exception {
        lab1();
        lab2();
        lab3();
        lab4();
        lab5();
        lab6();
        lab7();
        lab8();
        lab9();
        lab10();
    }

    static void lab1() {
        System.out.println("LAB 1");
        Car[] cars = {new Car("Toyota", 2000, 180_000), new Car("Ford", 2018, 75_000),
                new Car("Mazda", 1990, 240_000)};
        Arrays.stream(cars).forEach(Car::display);
        Rectangle[] rectangles = {new Rectangle(2, 5), new Rectangle(4, 4),
                new Rectangle(3, 7), new Rectangle(1, 9), new Rectangle(6, 2)};
        System.out.println("Largest rectangle area: " +
                Arrays.stream(rectangles).max(Comparator.comparingDouble(Rectangle::area)).orElseThrow().area());
    }

    static void lab2() {
        System.out.println("LAB 2");
        Book first = new Book("Clean Code", "Robert Martin", 39.99);
        Book second = new Book();
        first.display();
        second.display();
        System.out.println("Books created: " + Book.count());
        System.out.println("98F = " + Temperature.fromFahrenheit(98).celsius() + "C");
    }

    static void lab3() {
        System.out.println("LAB 3");
        MarkedStudent student = new MarkedStudent("Tariro", 87);
        System.out.println(student + " grade=" + student.grade());
        try {
            student.setMarks(101);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected invalid marks: " + e.getMessage());
        }
        ImmutablePerson person = new ImmutablePerson("Rudo", 21);
        System.out.println(person);
    }

    static void lab4() {
        System.out.println("LAB 4");
        Person[] people = {new Student("Anesu", 20, "OOP"), new Teacher("Dr Moyo", 42, "Java")};
        Arrays.stream(people).forEach(Person::display);
        Vehicle vehicle = new ElectricCar("EV-1", 80);
        System.out.println(vehicle.tripDescription(100));
        StackComposition<Integer> stack = new StackComposition<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Composed stack pop: " + stack.pop());
    }

    static void lab5() {
        System.out.println("LAB 5");
        Animal[] animals = {new Cat(), new Cow(), new Duck()};
        Arrays.stream(animals).forEach(Animal::sound);
        Employee[] payroll = {new Manager("M", 3000, 500), new Developer("D", 2500, 10),
                new Intern("I", 1000)};
        System.out.println("Payroll: " + Arrays.stream(payroll).mapToDouble(Employee::calculatePay).sum());
        PaymentProcessor.process(new CardPayment(120));
        PaymentProcessor.process(new MobileMoneyPayment(80));
    }

    static void lab6() {
        System.out.println("LAB 6");
        Shape[] shapes = {new Circle(2), new RectangleShape(3, 4), new Square(5)};
        Arrays.stream(shapes).forEach(s -> System.out.printf("area=%.2f perimeter=%.2f%n",
                s.area(), s.perimeter()));
        List<Player> players = new ArrayList<>(List.of(new Player("Anesu", 70),
                new Player("Blessing", 95), new Player("Chenai", 82)));
        Collections.sort(players);
        System.out.println(players);
    }

    static void lab7() {
        System.out.println("LAB 7");
        try {
            System.out.println(divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Division failed: " + e.getMessage());
        }
        Wallet wallet = new Wallet(100);
        try {
            wallet.spend(120);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage() + ", shortfall=" + e.shortfall());
        }
    }

    static void lab8() {
        System.out.println("LAB 8");
        List<Integer> numbers = new ArrayList<>(List.of(4, 2, 8, 2, 5, 4, 1, 9, 3, 6));
        System.out.println("sum=" + numbers.stream().mapToInt(Integer::intValue).sum()
                + ", max=" + numbers.stream().max(Integer::compareTo).orElseThrow());
        Set<String> names = new LinkedHashSet<>(List.of("Rudo", "Tariro", "Rudo", "Farai"));
        System.out.println(names);
        GenericStack<String> stack = new GenericStack<>();
        stack.push("A"); stack.push("B");
        System.out.println(stack.pop());
        System.out.println(wordFrequency("java is fun and java is useful"));
        Integer[] values = {4, 1, 3, 2};
        bubbleSort(values);
        System.out.println(Arrays.toString(values));
    }

    static void lab9() {
        System.out.println("LAB 9");
        System.out.println(Level.HIGH.advice());
        record StudentRecord(String name, int age) {}
        System.out.println(new StudentRecord("Tariro", 21));
        Set<IsbnBook> books = new HashSet<>(List.of(new IsbnBook("123", "Java"),
                new IsbnBook("123", "Same book")));
        System.out.println("Unique books: " + books.size());
        NestedCounter counter = new NestedCounter();
        System.out.println(counter.values());
    }

    static void lab10() throws IOException {
        System.out.println("LAB 10");
        Path file = Path.of("students-lab10.txt");
        Files.write(file, List.of("Tariro,101,3.8", "Farai,102,3.1", "Rudo,103,3.9"));
        try (var lines = Files.lines(file)) {
            System.out.println("High GPAs: " + lines.filter(line -> Double.parseDouble(line.split(",")[2]) >= 3.5)
                    .map(line -> line.split(",")[0]).toList());
        } finally {
            Files.deleteIfExists(file);
        }
        Function<String, String> upper = String::toUpperCase;
        System.out.println(upper.apply("lambdas"));
    }

    static int divide(int a, int b) { return a / b; }

    static <T extends Comparable<T>> void bubbleSort(T[] values) {
        for (int end = values.length - 1; end > 0; end--)
            for (int i = 0; i < end; i++)
                if (values[i].compareTo(values[i + 1]) > 0) {
                    T temp = values[i]; values[i] = values[i + 1]; values[i + 1] = temp;
                }
    }

    static Map<String, Long> wordFrequency(String text) {
        return Arrays.stream(text.toLowerCase().split("\\W+"))
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    }

    static final class Car {
        private final String brand; private final int year; private final int mileage;
        Car(String brand, int year, int mileage) { this.brand = brand; this.year = year; this.mileage = mileage; }
        void display() { System.out.println(brand + " " + year + " " + mileage + "km"); }
        boolean isAntique() { return Calendar.getInstance().get(Calendar.YEAR) - year > 25; }
    }
    static final class Rectangle {
        private final double width, height;
        Rectangle(double width, double height) { this.width = width; this.height = height; }
        double area() { return width * height; }
        double perimeter() { return 2 * (width + height); }
    }
    static final class Book {
        private static int count; private final String title, author; private final double price;
        Book(String title, String author, double price) { this.title = title; this.author = author; this.price = price; count++; }
        Book() { this("Untitled", "Unknown", 0); }
        static int count() { return count; }
        void display() { System.out.printf("%s by %s ($%.2f)%n", title, author, price); }
    }
    static final class Temperature {
        private final double kelvin;
        private Temperature(double kelvin) { if (kelvin < 0) throw new IllegalArgumentException("Below absolute zero"); this.kelvin = kelvin; }
        static Temperature fromFahrenheit(double f) { return new Temperature((f - 32) * 5 / 9 + 273.15); }
        double celsius() { return kelvin - 273.15; }
    }
    static class MarkedStudent {
        private final String name; private int marks;
        MarkedStudent(String name, int marks) { this.name = name; setMarks(marks); }
        void setMarks(int marks) { if (marks < 0 || marks > 100) throw new IllegalArgumentException("marks must be 0..100"); this.marks = marks; }
        String grade() { return marks >= 80 ? "A" : marks >= 70 ? "B" : marks >= 50 ? "C" : "F"; }
        public String toString() { return name + "(" + marks + ")"; }
    }
    static final class ImmutablePerson {
        private final String name; private final int age;
        ImmutablePerson(String name, int age) { this.name = name; this.age = age; }
        public String toString() { return name + "(" + age + ")"; }
    }
    static class Person {
        final String name; final int age;
        Person(String name, int age) { this.name = name; this.age = age; }
        void display() { System.out.println(name + ", age " + age); }
    }
    static final class Student extends Person { final String course; Student(String n, int a, String c) { super(n, a); course = c; } }
    static final class Teacher extends Person { final String subject; Teacher(String n, int a, String s) { super(n, a); subject = s; } }
    static class Vehicle {
        final String plate; Vehicle(String plate) { this.plate = plate; }
        String tripDescription(double km) { return plate + ": " + km + "km"; }
    }
    static final class ElectricCar extends Vehicle {
        final double range; ElectricCar(String p, double r) { super(p); range = r; }
        @Override String tripDescription(double km) { return super.tripDescription(km) + ", electric range " + range + "km"; }
    }
    static final class StackComposition<T> {
        private final List<T> values = new ArrayList<>();
        void push(T value) { values.add(value); }
        T pop() { if (values.isEmpty()) throw new NoSuchElementException(); return values.remove(values.size() - 1); }
    }
    interface Animal { void sound(); }
    static final class Cat implements Animal { public void sound() { System.out.println("meow"); } }
    static final class Cow implements Animal { public void sound() { System.out.println("moo"); } }
    static final class Duck implements Animal { public void sound() { System.out.println("quack"); } }
    static class Employee { final String name; final double salary; Employee(String n, double s) { name = n; salary = s; } double calculatePay() { return salary; } }
    static final class Manager extends Employee { final double bonus; Manager(String n, double s, double b) { super(n, s); bonus = b; } @Override double calculatePay() { return salary + bonus; } }
    static final class Developer extends Employee { final int hours; Developer(String n, double s, int h) { super(n, s); hours = h; } @Override double calculatePay() { return salary + hours * 25; } }
    static final class Intern extends Employee { Intern(String n, double s) { super(n, s); } }
    interface Payment { void process(); }
    static final class CardPayment implements Payment { final double amount; CardPayment(double a) { amount = a; } public void process() { System.out.println("Card payment: " + amount); } }
    static final class MobileMoneyPayment implements Payment { final double amount; MobileMoneyPayment(double a) { amount = a; } public void process() { System.out.println("Mobile money: " + amount); } }
    static final class PaymentProcessor { static void process(Payment payment) { payment.process(); } }
    static abstract class Shape { abstract double area(); abstract double perimeter(); }
    static final class Circle extends Shape { final double r; Circle(double r) { this.r = r; } double area() { return Math.PI * r * r; } double perimeter() { return 2 * Math.PI * r; } }
    static class RectangleShape extends Shape { final double w, h; RectangleShape(double w, double h) { this.w = w; this.h = h; } double area() { return w * h; } double perimeter() { return 2 * (w + h); } }
    static final class Square extends RectangleShape { Square(double side) { super(side, side); } }
    static final class Player implements Comparable<Player> { final String name; final int score; Player(String n, int s) { name = n; score = s; } public int compareTo(Player p) { return Integer.compare(p.score, score); } public String toString() { return name + "(" + score + ")"; } }
    static final class InsufficientFundsException extends Exception { final double shortfall; InsufficientFundsException(double s) { super("Insufficient funds"); shortfall = s; } double shortfall() { return shortfall; } }
    static final class Wallet { double balance; Wallet(double b) { balance = b; } void spend(double amount) throws InsufficientFundsException { if (amount > balance) throw new InsufficientFundsException(amount - balance); balance -= amount; } }
    static final class GenericStack<T> { final List<T> items = new ArrayList<>(); void push(T x) { items.add(x); } T pop() { return items.remove(items.size() - 1); } }
    enum Level { LOW, MEDIUM, HIGH; String advice() { return switch (this) { case LOW -> "Proceed"; case MEDIUM -> "Be careful"; case HIGH -> "Stop and review"; }; } }
    static final class IsbnBook { final String isbn, title; IsbnBook(String i, String t) { isbn = i; title = t; } public boolean equals(Object o) { return o instanceof IsbnBook b && isbn.equals(b.isbn); } public int hashCode() { return isbn.hashCode(); } }
    static final class NestedCounter {
        private final List<Integer> values = List.of(1, 2, 3);
        static final class Helper { static String label() { return "nested"; } }
        List<Integer> values() { return values; }
    }
}
