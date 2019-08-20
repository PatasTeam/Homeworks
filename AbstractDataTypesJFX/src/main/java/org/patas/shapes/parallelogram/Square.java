package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class Square extends Parallelogram {
    public Square(double side) {
        super("Square", side, side, Math.toRadians(90.0));
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeConstructor(Square.class.getDeclaredConstructors()[0]);
    }
}
