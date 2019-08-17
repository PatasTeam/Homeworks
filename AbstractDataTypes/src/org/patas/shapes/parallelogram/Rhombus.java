package org.patas.shapes.parallelogram;

import java.util.Scanner;

class Rhombus extends Parallelogram {
    private Rhombus(double side, double angleRad) {
        super("Rhombus", side, side, angleRad);
    }

    static Rhombus askForRhombus(Scanner sc) {
        double side, angleRad;
        while (true) {
            System.out.println("What do you know about the rhombus?");
            System.out.println("    1) Its side length and an angle in radians");
            System.out.println("    2) Its side length and an angle in degrees");
            System.out.println("    3) The length of its diagonals");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Side length: ");
                    side = sc.nextDouble();
                    System.out.println("Angle in radians: ");
                    angleRad = sc.nextDouble();
                    break;
                case 2:
                    System.out.println("Side length: ");
                    side = sc.nextDouble();
                    System.out.println("Angle in degrees: ");
                    angleRad = Math.toRadians(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Diagonal 1: ");
                    double diagonalA = sc.nextDouble();
                    System.out.println("Diagonal 2: ");
                    double diagonalB = sc.nextDouble();
                    side = Math.sqrt((diagonalA * diagonalA / 4) + (diagonalB * diagonalB / 4));
                    angleRad = 2 * Math.atan2(diagonalA, diagonalB);
                    break;
                default:
                    continue;
            }
            return new Rhombus(side, angleRad);
        }
    }
}
