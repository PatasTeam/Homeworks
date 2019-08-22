package org.patas.shapes.triangle;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

class EquilateralTriangle extends Triangle {
    private EquilateralTriangle(double side) throws InvalidShapeException {
        super("Equilateral Triangle", side, side, side);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new EquilateralTriangle(args[0]));
    }
}
