package org.patas;

import org.patas.shapes.ShapeFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ShapeFactory class creates and controls the Shape object
        ShapeFactory shapeFactory = new ShapeFactory(sc);
        while (shapeFactory.getShape() != null) {
            shapeFactory.askForCalculation();
            shapeFactory.askForShape();
        }
        sc.close();
    }
}
