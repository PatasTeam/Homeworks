package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

/**
 * Inherited class from Parallelogram that contains the
 * methods to define the radio buttons in the third horizontal separator
 * and to update the right box top pane in base of
 * the selected radio button in the third horizontal box
 * of the left box.
 */
class Rhomboid extends Parallelogram {
    /**
     * Class constructor defining the sideA, sideB and angle in radians
     * of the geometric figure.
     *
     * @throws InvalidShapeException if the shape is not valid.
     */
    private Rhomboid(double sideA, double sideB, double angleRad) throws InvalidShapeException {
        super("Rhomboid", sideA, sideB, angleRad);
    }

    /**
     * Defines the radio buttons inside the third horizontal box
     * inside the left box and its actions when selected.
     *
     * @param left the left box of the stage.
     * @param right the right box of the stage.
     * @return list of radio buttons that goes in the third horizontal box.
     */
    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup triangleGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton angleRadRB = new RadioButton("Side lengths and\nangle in radians");
        angleRadRB.setToggleGroup(triangleGroup);
        angleRadRB.setOnAction(event -> Rhomboid.setRightPaneWithRadians(right));
        result.add(angleRadRB);
        RadioButton angleDegRB = new RadioButton("Side lengths and\nangle in degrees");
        angleDegRB.setToggleGroup(triangleGroup);
        angleDegRB.setOnAction(event -> Rhomboid.setRightPaneWithDegrees(right));
        result.add(angleDegRB);
        return result;
    }

    /**
     * Defines the arraylist of labels
     * of the attributes of the shape
     * to show the text fields in the top panel
     * inside the right box if radians option radio
     * is selected.
     *
     * @param right right box of stage.
     */
    private static void setRightPaneWithRadians(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side A"));
        labels.add(new Label("Side B"));
        labels.add(new Label("Angle in radians"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Rhomboid(args[0], args[1], args[2]));
    }

    /**
     * Defines the arraylist of labels
     * of the attributes of the shape
     * to show the text fields in the top panel
     * inside the right box if degrees option radio
     * is selected.
     *
     * @param right right box of stage.
     */
    private static void setRightPaneWithDegrees(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side A"));
        labels.add(new Label("Side B"));
        labels.add(new Label("Angle in degrees"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Rhomboid(args[0], args[1], Math.toRadians(args[2])));
    }
}