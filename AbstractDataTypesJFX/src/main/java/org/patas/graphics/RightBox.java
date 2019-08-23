package org.patas.graphics;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import org.patas.shapes.Shape;
import org.patas.shapes.ShapeFactory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Inherited class from VBox that defines and changes the content
* inside the right box based on the selected radio element
* in the left box.
*/
public class RightBox extends VBox {
    private VBox topPanel;
    private ShapeFactory shapeFactory;
    private Label resultLbl, errorLbl;

    /**
     * Class constructor defining the top and bottom
     * panel of the right box, the top panel containing
     * the input text boxes and the bottom panel
     * containing the buttons to calculate area and
     * perimeter of the figure and below them the result label.
     */
    public RightBox() {
        this.setPrefSize(300.0, 450.0);
        topPanel = new VBox(10.0);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setPrefHeight(250.0);
        topPanel.setPadding(new Insets(10.0));
        VBox bottomPanel = setupBottomPanel();
        this.getChildren().addAll(topPanel, new Separator(Orientation.HORIZONTAL), bottomPanel);
    }

    /**
     * Creates the buttons in the vertical box
     * inside the right box and defines its action when clicked,
     * also the result and error labels are created.
     *
     * @return The vertical bottom box in the right pane.
     */
    private VBox setupBottomPanel() {
        Button calcAreaBtn = new Button("Calculate Area");
        calcAreaBtn.setOnAction(event -> {
            try {
                Shape shape = shapeFactory.createShape(getConstructorArgs());
                resultLbl.setText("Area: " + shape.calcArea());
                errorLbl.setText("");
            } catch (Exception e) {
                resultLbl.setText("");
                errorLbl.setText(e.getClass().getSimpleName() + "\n" + e.getMessage());
            }
        });
        Button calcPerimeterBtn = new Button("Calculate Perimeter");
        calcPerimeterBtn.setOnAction(event -> {
            try {
                Shape shape = shapeFactory.createShape(getConstructorArgs());
                resultLbl.setText("Perimeter: " + shape.calcPerimeter());
                errorLbl.setText("");
            } catch (Exception e) {
                resultLbl.setText("");
                errorLbl.setText(e.getMessage());
            }
        });
        HBox buttons = new HBox(10.0, calcAreaBtn, calcPerimeterBtn);
        buttons.setAlignment(Pos.CENTER);
        resultLbl = new Label("");
        errorLbl = new Label("Not epic");
        errorLbl.setTextFill(Color.RED);
        errorLbl.setTextAlignment(TextAlignment.CENTER);
        VBox bottomPanel = new VBox(15.0, buttons, resultLbl, errorLbl);
        bottomPanel.setPadding(new Insets(20, 0, 40, 0));
        bottomPanel.setAlignment(Pos.TOP_CENTER);
        return bottomPanel;
    }

    /**
     * Gets the values entered in the text fields.
     *
     * @return The values entered in the text fields.
     */
    private double[] getConstructorArgs() {
        ArrayList<Double> result = new ArrayList<>();
        for (Node node: topPanel.getChildren().filtered(node -> node.getClass().equals(TextField.class)))
            result.add(Double.parseDouble(((TextField) node).getText()));
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    /**
     * Deletes and creates the text fields in the vertical box inside the right
     * box based on the children parameter.
     * <p>
     * Note: Inside the method is contained a listener that checks if the input
     * in the text fields matches the int or double format.
     * </p>
     *
     * @param children list containing the labels of the options.
     * @return Nothing.
     */
    public void replaceTopPanel(ArrayList<Label> children) {
        topPanel.getChildren().clear();
        for (Label child : children) {
            TextField tf = new TextField();
            tf.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.equals("")) return;
                Matcher matcher = Pattern.compile("(\\d+\\.?\\d*)").matcher(newValue);
                tf.setText((matcher.matches()) ? matcher.group(0) : oldValue);
            });
            topPanel.getChildren().addAll(child, tf);
        }
    }

    /**
     * Class setter that defines the shapeFactory attribute.
     *
     * @param shapeFactory value to define in the attribute.
     * @return Nothing.
     */
    public void setShapeFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }
}
