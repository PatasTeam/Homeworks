package org.patas.shapes.parallelogram;

public class Rhombus extends Parallelogram {
    private double angle;

    public Rhombus(double side, double angle) {
        super("Rhombus", side, side);
        this.angle = angle;
    }

    public static Rhombus newRhombusByAngleInDegrees(double side, double angle) {
        return new Rhombus(side, Math.toRadians(angle));
    }

    public static Rhombus newRhombusByDiagonals(double diagonalA, double diagonalB) {
        double side = Math.sqrt((diagonalA * diagonalA / 4) * (diagonalB * diagonalB / 4));
        double angle = Math.atan2(diagonalA, diagonalB);
        return new Rhombus(side, angle);
    }

    @Override
    public double calcArea() {
        double diagonalA = sideA * Math.sqrt(2 + 2 * Math.cos(angle));
        double diagonalB = sideA * Math.sqrt(2 - 2 * Math.cos(angle));
        return diagonalA * diagonalB / 2;
    }
}
