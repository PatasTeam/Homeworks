package org.patas.shapes.triangle;

import org.patas.shapes.Shape;

import java.util.Scanner;

public abstract class Triangle extends Shape {
    private double[] sides;

    Triangle(String name, double side1, double side2, double side3) {
        super(name);
        sides = new double[] {side1, side2, side3};
    }

    public static Triangle askForTriangle(Scanner sc) {
        Triangle triangle = null;
        while (triangle == null) {
            System.out.println("Choose a triangle:");
            System.out.println("    1) Equilateral triangle");
            System.out.println("    2) Isosceles triangle");
            System.out.println("    3) Scalene triangle");
            switch (sc.nextInt()) {
                case 1:
                    triangle = EquilateralTriangle.askForEquilateralTriangle(sc);
                    break;
                case 2:
                    triangle = IsoscelesTriangle.askForIsoscelesTriangle(sc);
                    break;
                case 3:
                    triangle = ScaleneTriangle.askForScaleneTriangle(sc);
                    break;
            }
        }
        return triangle;
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
