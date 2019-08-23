package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

/**
 * Inherited class from Parallelogram that contains the
 * method to update the right box top pane.
 */
class Rectangle extends Parallelogram {
    /**
     * Class constructor defining the sideA and sideB
     * of the geometric figure.
     *
     * @throws InvalidShapeException if the shape is not valid.
     */
    private Rectangle(double sideA, double sideB) throws InvalidShapeException {
        super("Rectangle", sideA, sideB, Math.toRadians(90.0));
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
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Rectangle(args[0], args[1]));
    }
}
