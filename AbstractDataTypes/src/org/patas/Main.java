package org.patas;

import org.patas.shapes.Circle;
import org.patas.shapes.parallelogram.*;
import org.patas.shapes.Shape;
import org.patas.shapes.triangle.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape shape = askForShape(sc);
        while (shape != null) {
            askForCalculation(sc, shape);
            shape = askForShape(sc);
        }
        sc.close();
    }

    private static Shape askForShape(Scanner sc) {
        Shape shape;
        int sOption;
        do {
            System.out.println("Choose a shape (enter 0 to exit):");
            System.out.println("    1) Parallelogram");
            System.out.println("    2) Circle");
            System.out.println("    3) Triangle");
            sOption = sc.nextInt();
            switch (sOption) {
                case 1:
                    shape = askForParallelogram(sc);
                    break;
                case 2:
                    System.out.println("How long is its radius?");
                    double radius = sc.nextDouble();
                    shape = new Circle(radius);
                    break;
                case 3:
                    shape = askForTriangle(sc);
                    break;
                default:
                    shape = null;
                    System.exit(0);
            }
        } while (shape == null);
        return shape;
    }

    private static Parallelogram askForParallelogram(Scanner sc) {
        Parallelogram parallelogram = null;
        double sideA, sideB;
        int sOption;
        while (parallelogram == null) {
            System.out.println("Choose a parallelogram:");
            System.out.println("    1) Square");
            System.out.println("    2) Rectangle");
            System.out.println("    3) Rhombus");
            System.out.println("    4) Rhomboid");
            sOption = sc.nextInt();
            switch (sOption) {
                case 1:
                    System.out.println("How long is its side?");
                    double side = sc.nextDouble();
                    parallelogram = new Square(side);
                    break;
                case 2:
                    System.out.println("How long is one side?");
                    sideA = sc.nextDouble();
                    System.out.println("And the other one?");
                    sideB = sc.nextDouble();
                    parallelogram = new Rectangle(sideA, sideB);
                    break;
                case 3:
                    parallelogram = askForRhombusInfo(sc);
                    break;
                case 4:
                    System.out.println("Side A: ");
                    sideA = sc.nextDouble();
                    System.out.println("Side B: ");
                    sideB = sc.nextDouble();
                    System.out.println("Angle between A,B: ");
                    double angle = sc.nextDouble();
                    parallelogram = new Rhomboid(sideA, sideB, angle);
                    break;
            } 
        }
        return parallelogram;
    }

    private static Rhombus askForRhombusInfo(Scanner sc) {
        Rhombus rhombus = null;
        while (rhombus == null) {
            System.out.println("What do you know about the rhombus?");
            System.out.println("    1) Its side length and an angle in radians");
            System.out.println("    2) Its side length and an angle in degrees");
            System.out.println("    3) The length of its diagonals");
            int sOption = sc.nextInt();
            switch (sOption) {
                case 1:
                    System.out.println("Side length: ");
                    double side = sc.nextDouble();
                    System.out.println("Angle in radians: ");
                    double angle = sc.nextDouble();
                    rhombus = new Rhombus(side, angle);
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

    private static Triangle askForTriangle(Scanner sc) {
        Triangle triangle = null;
        int sOption;
        while (triangle == null) {
            System.out.println("Choose a triangle:");
            System.out.println("    1) Equilateral triangle");
            System.out.println("    2) Isosceles triangle");
            System.out.println("    3) Scalene triangle");
            sOption = sc.nextInt();
            switch (sOption) {
                case 1:
                    System.out.println("How long is its side?");
                    double side = sc.nextDouble();
                    triangle = new EquilateralTriangle(side);
                    break;
                case 2:
                    System.out.println("How long is its base?");
                    double base = sc.nextDouble();
                    System.out.println("How long are the equal sides?");
                    double equalSides = sc.nextDouble();
                    triangle = new IsoscelesTriangle(base, equalSides);
                    break;
                case 3:
                    System.out.println("How long is its first side?");
                    double side1 = sc.nextDouble();
                    System.out.println("How long is its second side?");
                    double side2 = sc.nextDouble();
                    System.out.println("How long is its third side?");
                    double side3 = sc.nextDouble();
                    triangle = new ScaleneTriangle(side1, side2, side3);
                    break;
            }
        }
        return triangle;
    }

    private static void askForCalculation(Scanner sc, Shape shape) {
        int calculation;
        do {
            System.out.println("What do you want to calculate? (enter 0 to exit)");
            System.out.println("    1) Area");
            System.out.println("    2) Perimeter");
            calculation = sc.nextInt();
            switch (calculation) {
                case 1:
                    System.out.println("Area: " + shape.calcArea());
                    break;
                case 2:
                    System.out.println("Perimeter: " + shape.calcPerimeter());
                    break;
            }
        } while (calculation != 0);
    }
    
}
