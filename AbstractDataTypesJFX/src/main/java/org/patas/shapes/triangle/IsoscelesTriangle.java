package org.patas.shapes.triangle;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class IsoscelesTriangle extends Triangle {
    private IsoscelesTriangle(double base, double equalSides) {
        super("Isosceles Triangle", base, equalSides, equalSides);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Base"));
        labels.add(new Label("Equal sides"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new IsoscelesTriangle(args[0], args[1]));
    }

}
