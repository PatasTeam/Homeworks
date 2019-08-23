package org.patas.shapes;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.parallelogram.Parallelogram;
import org.patas.shapes.polygon.Polygon;
import org.patas.shapes.triangle.Triangle;

import java.util.ArrayList;

/**
 * Abstract class that implements ShapeOperations and defines
 * the methods that the shapes must have;
 */
public abstract class Shape implements ShapeOperations {
    private String name;

    /**
     * Class constructor that defines the shape name.
     */
    protected Shape(String name) {
        this.name = name;
    }

    /**
     * Defines the radio buttons inside the first horizontal box
     * inside the left box and its actions when selected.
     *
     * @param left the left box of the stage.
     * @param right the right box of the stage.
     * @return list of radio buttons that goes in the first horizontal box.
     */
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
        polygonRB.setOnAction(event ->
                left.replaceHBox(1, Polygon.getOptions(left, right))
        );
        result.add(polygonRB);
        return result;
    }

    /**
     * Class getter that returns the shape name.
     *
     * @return Shape name.
     */
    public String getName() {
        return name;
    }
}
