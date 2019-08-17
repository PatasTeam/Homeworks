package org.patas.shapes.parallelogram;

import org.patas.shapes.Shape;

import java.lang.Math; 
public abstract class Parallelogram extends Shape {
    private double sideA, sideB, angle;

    public Parallelogram(String name, double sideA, double sideB, double angle) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.angle = Math.toRadians(angle);
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
