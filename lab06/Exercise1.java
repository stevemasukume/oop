/*
 * Question from the lab manual:
 * Basic: Create an abstract Shape with abstract area() and perimeter(), and implement Circle, Rectangle and Square.
 */
package lab06;
public class Exercise1 {
    static abstract class Shape{abstract double area();abstract double perimeter();}
    static class Circle extends Shape{double r;Circle(double r){this.r=r;}double area(){return Math.PI*r*r;}double perimeter(){return 2*Math.PI*r;}}
    static class Rectangle extends Shape{double w,h;Rectangle(double w,double h){this.w=w;this.h=h;}double area(){return w*h;}double perimeter(){return 2*(w+h);}}
    static class Square extends Rectangle{Square(double s){super(s,s);}}
    // Explanation: The abstract class defines the common shape contract while each concrete shape supplies its own formulas.
    public static void main(String[] args){Shape[] shapes={new Circle(2),new Rectangle(2,3),new Square(4)};for(Shape s:shapes)System.out.println(s.area());}
}

