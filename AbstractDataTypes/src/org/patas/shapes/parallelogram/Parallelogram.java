package org.patas.shapes.parallelogram;

import org.patas.shapes.Shape;

public abstract class Parallelogram extends Shape {
    private double sideA, sideB, angle;

    Parallelogram(String name, double sideA, double sideB, double angle) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.angle = angle;
    }
    
    @Override
    public double calcArea() {
        return sideA * sideB * Math.sin(angle);
    }

    @Override
    public double calcPerimeter() {
        return 2 * (sideA + sideB);
    }

}
