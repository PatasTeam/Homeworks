package org.patas.shapes;

public abstract class Shape implements ShapeOperations {
    private String name;

    public Shape(String name) {
        this.name = name;
    }
}
