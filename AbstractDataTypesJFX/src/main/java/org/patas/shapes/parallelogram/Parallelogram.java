package org.patas.shapes.parallelogram;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;
import org.patas.shapes.Shape;

import java.util.ArrayList;

public abstract class Parallelogram extends Shape {
    private double sideA, sideB, angleRad;

    Parallelogram(String name, double sideA, double sideB, double angleRad) throws InvalidShapeException {
        super(name);
        if (sideA == 0 || sideB == 0) throw new InvalidShapeException("Side length can't be zero");
        if (angleRad == 0) throw new InvalidShapeException("Angle between sides can't be zero");
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleRad = angleRad;
    }

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

    @Override
    public double calcArea() {
        return sideA * sideB * Math.sin(angleRad);
    }

    @Override
    public double calcPerimeter() {
        return 2 * (sideA + sideB);
    }
}
