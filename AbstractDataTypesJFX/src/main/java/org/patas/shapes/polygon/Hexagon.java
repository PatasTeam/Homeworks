package org.patas.shapes.polygon;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class Hexagon extends Polygon {
    public Hexagon(double side) {
        super("Hexagon", 6, side);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeConstructor(Hexagon.class.getDeclaredConstructors()[0]);
    }
}
