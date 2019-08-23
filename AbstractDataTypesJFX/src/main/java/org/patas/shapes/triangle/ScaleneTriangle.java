package org.patas.shapes.triangle;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

/**
 * Inherited class from Triangle that contains the
 * method to update the right box top pane.
 */
class ScaleneTriangle extends Triangle {
    /**
     * Class constructor defining the side1, side2 and side3
     * of the geometric figure.
     *
     * @throws InvalidShapeException if the shape is not valid.
     */
    private ScaleneTriangle(double side1, double side2, double side3) throws InvalidShapeException {
        super("Scalene Triangle", side1, side2, side3);
    }

    /**
     * Defines the arraylist of labels
     * of the attributes of the shape
     * to show the text fields in the top panel
     * inside the right box.
     *
     * @param right right box of stage.
     */
    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side A"));
        labels.add(new Label("Side B"));
        labels.add(new Label("Side C"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new ScaleneTriangle(args[0], args[1], args[2]));
    }
}
