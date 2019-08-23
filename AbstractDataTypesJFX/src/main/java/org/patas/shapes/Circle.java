package org.patas.shapes;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

/**
 * Inherited class from Shape that contains the
 * methods to calculate area and perimeter of the circle
 * and to update the right box top pane
 */
public class Circle extends Shape {
    private double radius;

    /**
     * Class constructor defining the name and radius
     * of the geometric figure.
     * 
     * @throws InvalidShapeException if the shape is not valid.
     */
    private Circle(double radius) throws InvalidShapeException {
        super("Circle");
        if (radius == 0) throw new InvalidShapeException("Radius can't be zero");
        this.radius = radius;
    }

    /**
     * Defines the arraylist of labels
     * of the attributes of the shape
     * to show the text fields in the top panel
     * inside the right box.
     * <p>
     * Throws InvalidShapeException if radius input is 0.
     * </p>
     *
     * @param right right box of stage.
     */
    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Radius"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Circle(args[0]));
    }

    /**
     * Calculates the area of the circle.
     *
     * @return value of the area.
     */
    @Override
    public double calcArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Calculates the perimeter of the circle.
     *
     * @return value of the perimeter.
     */
    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }
}
