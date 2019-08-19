package org.patas.shapes.parallelogram;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class Rhomboid extends Parallelogram {
    private Rhomboid(double sideA, double sideB, double angleRad) {
        super("Rhomboid", sideA, sideB, angleRad);
    }

    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup triangleGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton angleRadRB = new RadioButton("Side lengths and\nangle in radians");
        angleRadRB.setToggleGroup(triangleGroup);
        angleRadRB.setOnAction(event -> {
            left.clearDownFromIndex(3);
            // TODO: Add Rhomboid.setRightPaneWithRadians()
        });
        result.add(angleRadRB);
        RadioButton angleDegRB = new RadioButton("Side lengths and\nangle in degrees");
        angleDegRB.setToggleGroup(triangleGroup);
        angleDegRB.setOnAction(event -> {
            left.clearDownFromIndex(3);
            // TODO: Add Rhomboid.setRightPaneWithDegrees()
        });
        result.add(angleDegRB);
        return result;
    }
}