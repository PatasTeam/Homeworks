package org.patas.shapes.polygon;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class Heptagon extends Polygon {
    private Heptagon(double side) {
        super("Heptagon", 7, side);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Heptagon(args[0]));
    }
}
