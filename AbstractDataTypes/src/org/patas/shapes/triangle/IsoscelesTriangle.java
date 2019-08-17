package org.patas.shapes.triangle;

import java.util.Scanner;

class IsoscelesTriangle extends Triangle {
    private IsoscelesTriangle(double base, double equalSides) {
        super("Isosceles Triangle", base, equalSides, equalSides);
    }

    static IsoscelesTriangle askForIsoscelesTriangle(Scanner sc) {
        System.out.println("How long is its base?");
        double base = sc.nextDouble();
        System.out.println("How long are the equal sides?");
        double equalSides = sc.nextDouble();
        return new IsoscelesTriangle(base, equalSides);
    }
}
