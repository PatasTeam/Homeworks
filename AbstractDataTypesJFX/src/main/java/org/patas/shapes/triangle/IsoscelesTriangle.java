package org.patas.shapes.triangle;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double base, double equalSides) {
        super("Isosceles Triangle", base, equalSides, equalSides);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Base"));
        labels.add(new Label("Equal sides"));
        right.replaceTopPanel(labels);
        right.setShapeConstructor(IsoscelesTriangle.class.getDeclaredConstructors()[0]);
    }

}
