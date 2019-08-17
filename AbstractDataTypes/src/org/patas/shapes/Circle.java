package org.patas.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
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
