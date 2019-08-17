package org.patas.shapes.triangle;

import java.util.Scanner;

class ScaleneTriangle extends Triangle {
    private ScaleneTriangle(double side1, double side2, double side3) {
        super("Scalene Triangle", side1, side2, side3);
    }

    static ScaleneTriangle askForScaleneTriangle(Scanner sc) {
        System.out.println("How long is its first side?");
        double side1 = sc.nextDouble();
        System.out.println("How long is its second side?");
        double side2 = sc.nextDouble();
        System.out.println("How long is its third side?");
        double side3 = sc.nextDouble();
        return new ScaleneTriangle(side1, side2, side3);
    }
}
