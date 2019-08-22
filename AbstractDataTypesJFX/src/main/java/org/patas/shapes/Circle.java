package org.patas.shapes;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class Circle extends Shape {
    private double radius;

    private Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Radius"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> {
            if (args[0] == 0) throw new InvalidShapeException("Measure can't be zero");
            return new Circle(args[0]);
        });
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
