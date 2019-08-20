package org.patas.shapes.triangle;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super("Equilateral Triangle", side, side, side);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeConstructor(EquilateralTriangle.class.getDeclaredConstructors()[0]);
    }
}
