package org.patas.shapes.parallelogram;

import java.util.Scanner;

class Rhombus extends Parallelogram {
    private Rhombus(double side, double angleRad) {
        super("Rhombus", side, side, angleRad);
    }

    private static Rhombus newRhombusByAngleInDegrees(double side, double angleDeg) {
        return new Rhombus(side, Math.toRadians(angleDeg));
    }

    private static Rhombus newRhombusByDiagonals(double diagonalA, double diagonalB) {
        double side = Math.sqrt((diagonalA * diagonalA / 4) + (diagonalB * diagonalB / 4));
        double angleRad = 2 * Math.atan2(diagonalA, diagonalB);
        return new Rhombus(side, angleRad);
    }

    static Rhombus askForRhombus(Scanner sc) {
        Rhombus rhombus = null;
        while (rhombus == null) {
            System.out.println("What do you know about the rhombus?");
            System.out.println("    1) Its side length and an angle in radians");
            System.out.println("    2) Its side length and an angle in degrees");
            System.out.println("    3) The length of its diagonals");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Side length: ");
                    double side = sc.nextDouble();
                    System.out.println("Angle in radians: ");
                    double angleRad = sc.nextDouble();
                    rhombus = new Rhombus(side, angleRad);
                    break;
                case 2:
                    System.out.println("Side length: ");
                    double sideDeg = sc.nextDouble();
                    System.out.println("Angle in degrees: ");
                    double angleDeg = sc.nextDouble();
                    rhombus = Rhombus.newRhombusByAngleInDegrees(sideDeg, angleDeg);
                    break;
                case 3:
                    System.out.println("Diagonal 1: ");
                    double diagonalA = sc.nextDouble();
                    System.out.println("Diagonal 2: ");
                    double diagonalB = sc.nextDouble();
                    rhombus = Rhombus.newRhombusByDiagonals(diagonalA, diagonalB);
                    break;
            }
        }
        return rhombus;
    }
}
