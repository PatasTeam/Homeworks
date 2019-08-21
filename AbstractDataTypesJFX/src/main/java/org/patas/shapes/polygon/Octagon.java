package org.patas.shapes.polygon;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class Octagon extends Polygon {
    private Octagon(double side) {
        super("Octagon", 8, side);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Octagon(args[0]));
    }
}
