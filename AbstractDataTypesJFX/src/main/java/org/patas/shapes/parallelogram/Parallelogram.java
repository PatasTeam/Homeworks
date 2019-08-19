package org.patas.shapes.parallelogram;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.Shape;

import java.util.ArrayList;

public abstract class Parallelogram extends Shape {
    private double sideA, sideB, angleRad;

    Parallelogram(String name, double sideA, double sideB, double angleRad) {
        super(name);
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
            left.clearDownFromIndex(2);
            // TODO: Add Square.setRightPane()
        });
        result.add(squareRB);
        RadioButton rectangleRB = new RadioButton("Rectangle");
        rectangleRB.setToggleGroup(triangleGroup);
        rectangleRB.setOnAction(event -> {
            left.clearDownFromIndex(2);
            // TODO: Add Rectangle.setRightPane()
        });
        result.add(rectangleRB);
        RadioButton rhombusRB = new RadioButton("Rhombus");
        rhombusRB.setToggleGroup(triangleGroup);
        rhombusRB.setOnAction(event -> {
            left.clearDownFromIndex(2);
            left.getPane(2).getChildren().addAll(Rhombus.getOptions(left, right));
        });
        result.add(rhombusRB);
        RadioButton rhomboidRB = new RadioButton("Rhomboid");
        rhomboidRB.setToggleGroup(triangleGroup);
        rhomboidRB.setOnAction(event -> {
            left.clearDownFromIndex(2);
            left.getPane(2).getChildren().addAll(Rhomboid.getOptions(left, right));
        });
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
