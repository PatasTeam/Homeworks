package org.patas.shapes.parallelogram;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

class Rhombus extends Parallelogram {
    private Rhombus(double side, double angleRad) {
        super("Rhombus", side, side, angleRad);
    }

    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup triangleGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton angleRadRB = new RadioButton("Side length and\nangle in radians");
        angleRadRB.setToggleGroup(triangleGroup);
        angleRadRB.setOnAction(event -> {
            left.clearDownFromIndex(3);
            // TODO: Add Rhombus.setRightPaneWithRadians()
        });
        result.add(angleRadRB);
        RadioButton angleDegRB = new RadioButton("Side length and\nangle in degrees");
        angleDegRB.setToggleGroup(triangleGroup);
        angleDegRB.setOnAction(event -> {
            left.clearDownFromIndex(3);
            // TODO: Add Rhombus.setRightPaneWithDegrees()
        });
        result.add(angleDegRB);
        RadioButton diagonalsRB = new RadioButton("Length of diagonals");
        diagonalsRB.setToggleGroup(triangleGroup);
        diagonalsRB.setOnAction(event -> {
            left.clearDownFromIndex(3);
            // TODO: Add Rhombus.setRightPaneWithDiagonals()
        });
        result.add(diagonalsRB);
        return result;
    }
}
