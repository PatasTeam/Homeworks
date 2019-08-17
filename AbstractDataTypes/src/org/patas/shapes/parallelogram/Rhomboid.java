package org.patas.shapes.parallelogram;

import java.util.Scanner;

class Rhomboid extends Parallelogram {
    private Rhomboid(double sideA, double sideB, double angleRad) {
        super("Rhomboid", sideA, sideB, angleRad);
    }

    static Rhomboid askForRhomboid(Scanner sc) {
        double sideA, sideB, angleRad;
        while (true) {
            System.out.println("What do you know about the rhomboid?");
            System.out.println("    1) Its side lengths and an angle in radians");
            System.out.println("    2) Its side lengths and an angle in degrees");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Side A: ");
                    sideA = sc.nextDouble();
                    System.out.println("Side B: ");
                    sideB = sc.nextDouble();
                    System.out.println("Angle between sides: ");
                    angleRad = sc.nextDouble();
                    break;
                case 2:
                    System.out.println("Side A: ");
                    sideA = sc.nextDouble();
                    System.out.println("Side B: ");
                    sideB = sc.nextDouble();
                    System.out.println("Angle between sides: ");
                    angleRad = Math.toRadians(sc.nextDouble());
                    break;
                default:
                    continue;
            }
            return new Rhomboid(sideA, sideB, angleRad);
        }
    }
}