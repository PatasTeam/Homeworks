package org.patas.shapes;

import java.util.Scanner;

public class Circle extends Shape {
    private double radius;

    private Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    static Circle askForCircle(Scanner sc) {
        System.out.println("How long is its radius?");
        double radius = sc.nextDouble();
        return new Circle(radius);
    }

    @Override
    public double calcArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }
}
