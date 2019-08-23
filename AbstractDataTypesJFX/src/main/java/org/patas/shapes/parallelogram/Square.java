package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

/**
 * Inherited class from Parallelogram that contains the
 * method to update the right box top pane.
 */
class Square extends Parallelogram {
    /**
     * Class constructor defining the side
     * of the geometric figure.
     *
     * @throws InvalidShapeException if the shape is not valid.
     */
    private Square(double side) throws InvalidShapeException {
        super("Square", side, side, Math.toRadians(90.0));
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
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Square(args[0]));
    }
}
