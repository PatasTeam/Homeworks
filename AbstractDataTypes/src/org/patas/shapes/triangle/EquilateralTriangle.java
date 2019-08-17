package org.patas.shapes.triangle;

import java.util.Scanner;

class EquilateralTriangle extends Triangle {
    private EquilateralTriangle(double side) {
        super("Equilateral Triangle", side, side, side);
    }

    static EquilateralTriangle askForEquilateralTriangle(Scanner sc) {
        System.out.println("How long is its side?");
        double side = sc.nextDouble();
        return new EquilateralTriangle(side);
    }
}
