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

public class RightBox extends VBox {
    private VBox topPanel;
    private ShapeFactory shapeFactory;
    private Label resultLbl, errorLbl;

    public RightBox() {
        this.setPrefSize(300.0, 450.0);
        topPanel = new VBox(10.0);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setPrefHeight(250.0);
        topPanel.setPadding(new Insets(10.0));
        VBox bottomPanel = setupBottomPanel();
        this.getChildren().addAll(topPanel, new Separator(Orientation.HORIZONTAL), bottomPanel);
    }

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
                errorLbl.setText(e.getClass().getSimpleName() + "\n" + e.getMessage());
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
     * Parses numbers from TextFields to a double array
     *
     * @return a double array with the parameters for the lambda
     */
    private double[] getConstructorArgs() {
        ArrayList<Double> result = new ArrayList<>();
        for (Node node: topPanel.getChildren().filtered(node -> node.getClass().equals(TextField.class)))
            result.add(Double.parseDouble(((TextField) node).getText()));
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    /**
     * Adds the labels passed and a TextField for every label to the top panel of RightBox
     *
     * @param labels ArrayList of labels to add
     */
    public void replaceTopPanel(ArrayList<Label> labels) {
        topPanel.getChildren().clear();
        for (Label label : labels) {
            TextField tf = new TextField();
            tf.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.equals("")) return;
                Matcher matcher = Pattern.compile("(\\d+\\.?\\d*)").matcher(newValue);
                tf.setText((matcher.matches()) ? matcher.group(0) : oldValue);
            });
            topPanel.getChildren().addAll(label, tf);
        }
    }

    /**
     * Sets a interface to execute the constructor of every shape.
     * Usually implemented as a lambda function
     * @param shapeFactory ShapeFactory implementation
     */
    public void setShapeFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }
}
