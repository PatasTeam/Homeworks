package org.patas.shapes.polygon;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;
import org.patas.shapes.Shape;

import java.util.ArrayList;

public abstract class Polygon extends Shape {
    private int numSides;
    private double side;

    Polygon(String name, int numSides, double side) throws InvalidShapeException {
        super(name);
        if (side == 0) throw new InvalidShapeException("Side length can't be zero");
        this.side = side;
        this.numSides = numSides;
    }

    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup triangleGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton pentagonRB = new RadioButton("Pentagon");
        pentagonRB.setToggleGroup(triangleGroup);
        pentagonRB.setOnAction(event -> {
            left.replaceHBox(2);
            Pentagon.setRightPane(right);
        });
        result.add(pentagonRB);
        RadioButton hexagonRB = new RadioButton("Hexagon");
        hexagonRB.setToggleGroup(triangleGroup);
        hexagonRB.setOnAction(event -> {
            left.replaceHBox(2);
            Hexagon.setRightPane(right);
        });
        result.add(hexagonRB);
        RadioButton heptagonRB = new RadioButton("Heptagon");
        heptagonRB.setToggleGroup(triangleGroup);
        heptagonRB.setOnAction(event -> {
            left.replaceHBox(2);
            Heptagon.setRightPane(right);
        });
        result.add(heptagonRB);
        RadioButton octagonRB = new RadioButton("Octagon");
        octagonRB.setToggleGroup(triangleGroup);
        octagonRB.setOnAction(event -> {
            left.replaceHBox(2);
            Octagon.setRightPane(right);
        });
        result.add(octagonRB);
        return result;
    }

    @Override
    public double calcArea() {
        return side * side * numSides / (4.0 * Math.tan(Math.PI / numSides));
    }

    @Override
    public double calcPerimeter() {
        return side * numSides;
    }
}
