package org.patas.shapes;

import org.patas.shapes.parallelogram.*;
import org.patas.shapes.triangle.Triangle;

import java.util.Scanner;

public class ShapeFactory {
    private Shape shape;
    private Scanner sc;

    public ShapeFactory(Scanner sc) {
        this.sc = sc;
        askForShape();
    }

    // Method to set information of shape object
    public void askForShape() {
        this.shape = null;
        while (shape == null) {
            System.out.println("Choose a shape (enter 0 to exit):");
            System.out.println("    1) Parallelogram");
            System.out.println("    2) Circle");
            System.out.println("    3) Triangle");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    shape = Parallelogram.askForParallelogram(sc);
                    break;
                case 2:
                    shape = Circle.askForCircle(sc);
                    break;
                case 3:
                    shape = Triangle.askForTriangle(sc);
                    break;
            }
        }
    }

    // Method to calculate perimeter and area
    public void askForCalculation() {
        while (true) {
            System.out.println("What do you want to calculate? (enter 0 to exit)");
            System.out.println("    1) Area");
            System.out.println("    2) Perimeter");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    System.out.println("Area: " + shape.calcArea());
                    break;
                case 2:
                    System.out.println("Perimeter: " + shape.calcPerimeter());
                    break;
            }
        }
    }

    public Shape getShape() {
        return shape;
    }
}
