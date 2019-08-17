package org.patas.shapes.triangle;

import org.patas.shapes.Shape;

public abstract class Triangle extends Shape {
    private double[] sides;

    public Triangle(String name, double side1, double side2, double side3) {
        super(name);
        sides = new double[] {side1, side2, side3};
    }

    @Override
    public double calcArea() {
        return Math.sqrt(calcSemiPerimeter() * (calcSemiPerimeter() - sides[0]) *
                (calcSemiPerimeter() - sides[1]) * (calcSemiPerimeter() - sides[2]));
    }

    private double calcSemiPerimeter() {
        return calcPerimeter() / 2;
    }

    @Override
    public double calcPerimeter() {
        return sides[0] + sides[1] + sides[2];
    }
}
