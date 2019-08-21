package org.patas.shapes.triangle;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class ScaleneTriangle extends Triangle {
    private ScaleneTriangle(double side1, double side2, double side3) {
        super("Scalene Triangle", side1, side2, side3);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side A"));
        labels.add(new Label("Side B"));
        labels.add(new Label("Side C"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new ScaleneTriangle(args[0], args[1], args[2]));
    }
}
