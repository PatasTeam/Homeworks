package org.patas.shapes;

import org.patas.shapes.parallelogram.Parallelogram;
import org.patas.shapes.triangle.Triangle;

import java.util.Scanner;

public abstract class Shape implements ShapeOperations {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public static Shape askForShape(Scanner sc) {
        Shape shape = null;
        while (shape == null) {
            System.out.println("Choose a shape (enter 0 to exit):");
            System.out.println("    1) Parallelogram");
            System.out.println("    2) Circle");
            System.out.println("    3) Triangle");
            switch (sc.nextInt()) {
                case 0:
                    return null;
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
        return shape;
    }

    public String getName() {
        return name;
    }
}
