package org.patas.shapes.parallelogram;

import java.util.Scanner;

class Square extends Parallelogram {
    private Square(double side) {
        super("Square", side, side, Math.toRadians(90.0));
    }

    static Square askForSquare(Scanner sc) {
        System.out.println("How long is its side?");
        double side = sc.nextDouble();
        return new Square(side);
    }
}
