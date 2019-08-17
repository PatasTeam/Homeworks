package org.patas.shapes.parallelogram;

import java.util.Scanner;

class Rhomboid extends Parallelogram {
    private Rhomboid(double sideA, double sideB, double angleDeg) {
        super("Rhomboid", sideA, sideB, Math.toRadians(angleDeg));
    }

    static Rhomboid askForRhomboid(Scanner sc) {
        System.out.println("Side A: ");
        double sideA = sc.nextDouble();
        System.out.println("Side B: ");
        double sideB = sc.nextDouble();
        System.out.println("Angle between sides A,B (degrees): ");
        double angle = sc.nextDouble();
        return new Rhomboid(sideA, sideB, angle);
    }
}