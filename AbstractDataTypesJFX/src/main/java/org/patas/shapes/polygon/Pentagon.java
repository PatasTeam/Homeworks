package org.patas.shapes.polygon;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

/**
 * Inherited class from Polygon that contains the
 * method to update the right box top pane.
 */
class Pentagon extends Polygon {
    /**
     * Class constructor defining the side
     * of the geometric figure.
     *
     * @throws InvalidShapeException if the shape is not valid.
     */
    private Pentagon(double side) throws InvalidShapeException {
        super("Pentagon", 5, side);
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
        right.setShapeFactory(args -> new Pentagon(args[0]));
    }
}
