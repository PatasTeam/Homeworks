package org.patas.shapes.polygon;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class Hexagon extends Polygon {
    private Hexagon(double side) {
        super("Hexagon", 6, side);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Hexagon(args[0]));
    }
}
