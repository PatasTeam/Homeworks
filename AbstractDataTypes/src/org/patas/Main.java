package org.patas;

import org.patas.shapes.Shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape shape = Shape.askForShape(sc);
        while (shape != null) {
            askForCalculation(sc, shape);
            shape = Shape.askForShape(sc);
        }
        sc.close();
    }

    private static void askForCalculation(Scanner sc, Shape shape) {
        while (true) {
            System.out.println("What do you want to calculate? (enter 0 to exit)");
            System.out.println("    1) Area");
            System.out.println("    2) Perimeter");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    System.out.println("Area: " + shape.calcArea());
                    break;
                case 2:
                    System.out.println("Perimeter: " + shape.calcPerimeter());
                    break;
            }
        }
    }
}
