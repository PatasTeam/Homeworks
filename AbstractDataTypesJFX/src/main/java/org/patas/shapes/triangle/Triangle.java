package org.patas.shapes.triangle;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;
import org.patas.shapes.Shape;

import java.util.ArrayList;

public abstract class Triangle extends Shape {
    private double[] sides;

    Triangle(String name, double side1, double side2, double side3) throws InvalidShapeException {
        super(name);
        if (side1 == 0 || side2 == 0 || side3 == 0)
            throw new InvalidShapeException("Measure can't be zero");
        if ((side1 + side2 <= side3) || (side1 + side3 <= side2) || (side3 + side2 <= side1))
            throw new InvalidShapeException("A side can't be longer than\nthe sum of the others");
        sides = new double[] {side1, side2, side3};
    }

    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup triangleGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton equilateralRB = new RadioButton("Equilateral");
        equilateralRB.setToggleGroup(triangleGroup);
        equilateralRB.setOnAction(event -> {
            left.replaceHBox(2);
            EquilateralTriangle.setRightPane(right);
        });
        result.add(equilateralRB);
        RadioButton isoscelesRB = new RadioButton("Isosceles");
        isoscelesRB.setToggleGroup(triangleGroup);
        isoscelesRB.setOnAction(event -> {
            left.replaceHBox(2);
            IsoscelesTriangle.setRightPane(right);
        });
        result.add(isoscelesRB);
        RadioButton scaleneRB = new RadioButton("Scalene");
        scaleneRB.setToggleGroup(triangleGroup);
        scaleneRB.setOnAction(event -> {
            left.replaceHBox(2);
            ScaleneTriangle.setRightPane(right);
        });
        result.add(scaleneRB);
        return result;
    }

    @Override
    public double calcArea() {
        return Math.sqrt(calcSemiPerimeter() * (calcSemiPerimeter() - sides[0]) *
                (calcSemiPerimeter() - sides[1]) * (calcSemiPerimeter() - sides[2]));
    }

    private double calcSemiPerimeter() {
        return calcPerimeter() / 2;
    }

    @Override
    public double calcPerimeter() {
        return sides[0] + sides[1] + sides[2];
    }
}
