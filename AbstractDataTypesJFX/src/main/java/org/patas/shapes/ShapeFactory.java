package org.patas.shapes;

public interface ShapeFactory {
    Shape createShape(double[] args) throws InvalidShapeException;
}
