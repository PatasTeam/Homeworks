package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
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
        angleRadRB.setOnAction(event -> Rhomboid.setRightPaneWithRadians(right));
        result.add(angleRadRB);
        RadioButton angleDegRB = new RadioButton("Side lengths and\nangle in degrees");
        angleDegRB.setToggleGroup(triangleGroup);
        angleDegRB.setOnAction(event -> Rhomboid.setRightPaneWithDegrees(right));
        result.add(angleDegRB);
        return result;
    }

    private static void setRightPaneWithRadians(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side A"));
        labels.add(new Label("Side B"));
        labels.add(new Label("Angle in radians"));
        right.replaceTopPanel(labels);
        right.setShapeConstructor(Rhomboid.class.getDeclaredConstructors()[0]);
    }

    private static void setRightPaneWithDegrees(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side A"));
        labels.add(new Label("Side B"));
        labels.add(new Label("Angle in degrees"));
        right.replaceTopPanel(labels);
        // TODO: pass another constructor or find a way to fix this
        right.setShapeConstructor(Rhomboid.class.getDeclaredConstructors()[0]);
    }
}