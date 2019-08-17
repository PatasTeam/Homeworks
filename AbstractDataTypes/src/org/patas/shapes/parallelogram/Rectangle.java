package org.patas.shapes.parallelogram;

import java.util.Scanner;

class Rectangle extends Parallelogram {
    private Rectangle(double sideA, double sideB) {
        super("Rectangle", sideA, sideB, Math.toRadians(90.0));
    }

    static Rectangle askForRectangle(Scanner sc) {
        System.out.println("How long is one side?");
        double sideA = sc.nextDouble();
        System.out.println("And the other one?");
        double sideB = sc.nextDouble();
        return new Rectangle(sideA, sideB);
    }
}
