import java.util.*;

public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.println("Area of circle: " + calculateArea());
        System.out.println("Circumference of circle: " + calculateCircumference());
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(12.4);
        circle1.display();
    }
}
