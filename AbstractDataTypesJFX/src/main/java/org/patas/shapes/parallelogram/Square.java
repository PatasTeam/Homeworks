package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class Square extends Parallelogram {
    private Square(double side) {
        super("Square", side, side, Math.toRadians(90.0));
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Square(args[0]));
    }
}
