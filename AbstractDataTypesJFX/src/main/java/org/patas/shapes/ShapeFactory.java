package org.patas.shapes;

/**
 * Interface with just one method, so it can be used as a method.
 */
public interface ShapeFactory {
    Shape createShape(double[] args) throws InvalidShapeException;
}
