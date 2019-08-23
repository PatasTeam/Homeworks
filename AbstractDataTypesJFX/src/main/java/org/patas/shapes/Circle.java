package org.patas.shapes;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class Circle extends Shape {
    private double radius;

    private Circle(double radius) throws InvalidShapeException {
        super("Circle");
        if (radius == 0) throw new InvalidShapeException("Radius can't be zero");
        this.radius = radius;
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Radius"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Circle(args[0]));
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
