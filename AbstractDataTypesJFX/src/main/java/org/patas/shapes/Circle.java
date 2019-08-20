package org.patas.shapes;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Radius"));
        right.replaceTopPanel(labels);
        right.setShapeConstructor(Circle.class.getDeclaredConstructors()[0]);
    }

    @Override
    public double calcArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }
}
