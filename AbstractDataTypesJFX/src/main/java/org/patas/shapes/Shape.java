package org.patas.shapes;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.parallelogram.Parallelogram;
import org.patas.shapes.triangle.Triangle;

import java.util.ArrayList;

public abstract class Shape implements ShapeOperations {
    private String name;

    protected Shape(String name) {
        this.name = name;
    }

    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup shapeGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton circleRB = new RadioButton("Circle");
        circleRB.setToggleGroup(shapeGroup);
        circleRB.setOnAction(event -> {
            left.replaceHBox(1);
            Circle.setRightPane(right);
        });
        result.add(circleRB);
        RadioButton triangleRB = new RadioButton("Triangle");
        triangleRB.setToggleGroup(shapeGroup);
        triangleRB.setOnAction(event ->
            left.replaceHBox(1, Triangle.getOptions(left, right))
        );
        result.add(triangleRB);
        RadioButton parallelogramRB = new RadioButton("Parallelogram");
        parallelogramRB.setToggleGroup(shapeGroup);
        parallelogramRB.setOnAction(event ->
            left.replaceHBox(1, Parallelogram.getOptions(left, right))
        );
        result.add(parallelogramRB);
        RadioButton polygonRB = new RadioButton("Polygon");
        polygonRB.setToggleGroup(shapeGroup);
        polygonRB.setOnAction(event -> {
            // TODO: Add Polygon.getOptions as argument
            left.replaceHBox(1);
        });
        result.add(polygonRB);
        return result;
    }

    public String getName() {
        return name;
    }
}
