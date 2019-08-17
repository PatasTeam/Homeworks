package org.patas.shapes.parallelogram;

import org.patas.shapes.Shape;

public abstract class Parallelogram extends Shape {
    double sideA, sideB;

    Parallelogram(String name, double sideA, double sideB) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calcArea() {
        return sideA * sideB;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (sideA + sideB);
    }
}
