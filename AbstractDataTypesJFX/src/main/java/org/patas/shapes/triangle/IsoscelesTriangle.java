package org.patas.shapes.triangle;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

/**
 * Inherited class from Triangle that contains the
 * method to update the right box top pane.
 */
class IsoscelesTriangle extends Triangle {
    /**
     * Class constructor defining the base and equalSides
     * of the geometric figure.
     *
     * @throws InvalidShapeException if the shape is not valid.
     */
    private IsoscelesTriangle(double base, double equalSides) throws InvalidShapeException {
        super("Isosceles Triangle", base, equalSides, equalSides);
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
        labels.add(new Label("Base"));
        labels.add(new Label("Equal sides"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new IsoscelesTriangle(args[0], args[1]));
    }

}
