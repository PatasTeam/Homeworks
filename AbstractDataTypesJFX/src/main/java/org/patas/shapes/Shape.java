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
            left.clearDownFromIndex(1);
            // TODO: Add Circle.setRightPane()
        });
        result.add(circleRB);
        RadioButton triangleRB = new RadioButton("Triangle");
        triangleRB.setToggleGroup(shapeGroup);
        triangleRB.setOnAction(event -> {
            left.clearDownFromIndex(1);
            left.getPane(1).getChildren().addAll(Triangle.getOptions(left, right));
        });
        result.add(triangleRB);
        RadioButton parallelogramRB = new RadioButton("Parallelogram");
        parallelogramRB.setToggleGroup(shapeGroup);
        parallelogramRB.setOnAction(event -> {
            left.clearDownFromIndex(1);
            left.getPane(1).getChildren().addAll(Parallelogram.getOptions(left, right));
        });
        result.add(parallelogramRB);
        RadioButton polygonRB = new RadioButton("Polygon");
        polygonRB.setToggleGroup(shapeGroup);
        result.add(polygonRB);
        return result;
    }

    public String getName() {
        return name;
    }
}
