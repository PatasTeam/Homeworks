package org.patas.shapes.parallelogram;

import org.patas.shapes.Shape;

import java.util.Scanner;

public abstract class Parallelogram extends Shape {
    private double sideA, sideB, angleRad;

    Parallelogram(String name, double sideA, double sideB, double angleRad) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleRad = angleRad;
    }

    public static Parallelogram askForParallelogram(Scanner sc) {
        Parallelogram parallelogram = null;
        while (parallelogram == null) {
            System.out.println("Choose a parallelogram:");
            System.out.println("    1) Square");
            System.out.println("    2) Rectangle");
            System.out.println("    3) Rhombus");
            System.out.println("    4) Rhomboid");
            switch (sc.nextInt()) {
                case 1:
                    parallelogram = Square.askForSquare(sc);
                    break;
                case 2:
                    parallelogram = Rectangle.askForRectangle(sc);
                    break;
                case 3:
                    parallelogram = Rhombus.askForRhombus(sc);
                    break;
                case 4:
                    parallelogram = Rhomboid.askForRhomboid(sc);
                    break;
            }
        }
        return parallelogram;
    }

    @Override
    public double calcArea() {
        return sideA * sideB * Math.sin(angleRad);
    }

    @Override
    public double calcPerimeter() {
        return 2 * (sideA + sideB);
    }
}
