package org.patas.shapes.parallelogram;

public class Rhombus extends Parallelogram {

    public Rhombus(double side, double angle) {
        super("Rhombus", side, side, angle);
    }

    public static Rhombus newRhombusByAngleInDegrees(double side, double angle) {
        return new Rhombus(side, Math.toRadians(angle));
    }

    public static Rhombus newRhombusByDiagonals(double diagonalA, double diagonalB) {
        double side = Math.sqrt((diagonalA * diagonalA / 4) + (diagonalB * diagonalB / 4));
        double angle = 2 * Math.atan2(diagonalA, diagonalB);
        return new Rhombus(side, angle);
    }
}
