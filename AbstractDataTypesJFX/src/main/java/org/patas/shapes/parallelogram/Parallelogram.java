package org.patas.shapes.parallelogram;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;
import org.patas.shapes.Shape;

import java.util.ArrayList;

/**
 * Abstract class inherited from Shape which contains the methods
 * to define the radio buttons inside the third horizontal separator
 * in the left box and to calculate the perimeter and area of the
 * parallelogram.
 */
public abstract class Parallelogram extends Shape {
    private double sideA, sideB, angleRad;

    /**
     * Class constructor that defines the parallelogram sides and angle.
     *
     * @throws InvalidShapeException if the shape is not valid.
     */
    Parallelogram(String name, double sideA, double sideB, double angleRad) throws InvalidShapeException {
        super(name);
        if (sideA == 0 || sideB == 0) throw new InvalidShapeException("Side length can't be zero");
        if (angleRad == 0) throw new InvalidShapeException("Angle can't be zero");
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleRad = angleRad;
    }

    /**
     * Defines the radio buttons inside the second horizontal box
     * inside the left box and its actions when selected.
     *
     * @param left the left box of the stage.
     * @param right the right box of the stage.
     * @return list of radio buttons that goes in the second horizontal box.
     */
    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup triangleGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton squareRB = new RadioButton("Square");
        squareRB.setToggleGroup(triangleGroup);
        squareRB.setOnAction(event -> {
            left.replaceHBox(2);
            Square.setRightPane(right);
        });
        result.add(squareRB);
        RadioButton rectangleRB = new RadioButton("Rectangle");
        rectangleRB.setToggleGroup(triangleGroup);
        rectangleRB.setOnAction(event -> {
            left.replaceHBox(2);
            Rectangle.setRightPane(right);
        });
        result.add(rectangleRB);
        RadioButton rhombusRB = new RadioButton("Rhombus");
        rhombusRB.setToggleGroup(triangleGroup);
        rhombusRB.setOnAction(event ->
            left.replaceHBox(2, Rhombus.getOptions(left, right))
        );
        result.add(rhombusRB);
        RadioButton rhomboidRB = new RadioButton("Rhomboid");
        rhomboidRB.setToggleGroup(triangleGroup);
        rhomboidRB.setOnAction(event ->
            left.replaceHBox(2, Rhomboid.getOptions(left, right))
        );
        result.add(rhomboidRB);
        return result;
    }

    /**
     * Calculates the area of the parallelogram.
     *
     * @return value of the area.
     */
    @Override
    public double calcArea() {
        return sideA * sideB * Math.sin(angleRad);
    }

    /**
     * Calculates the perimeter of the parallelogram.
     *
     * @return value of the perimeter.
     */
    @Override
    public double calcPerimeter() {
        return 2 * (sideA + sideB);
    }
}
