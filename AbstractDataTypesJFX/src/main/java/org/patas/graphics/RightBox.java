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
import org.patas.shapes.Shape;
import org.patas.shapes.ShapeFactory;

import java.util.ArrayList;

public class RightBox extends VBox {
    private VBox topPanel;
    private ShapeFactory shapeFactory;
    private Label resultLabel;

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
            Shape shape = shapeFactory.createShape(getConstructorArgs());
            resultLabel.setText("Area: " + shape.calcArea());
        });
        Button calcPerimeterBtn = new Button("Calculate Perimeter");
        calcPerimeterBtn.setOnAction(event -> {
            Shape shape = shapeFactory.createShape(getConstructorArgs());
            resultLabel.setText("Perimeter: " + shape.calcPerimeter());
        });
        HBox buttons = new HBox(10.0, calcAreaBtn, calcPerimeterBtn);
        buttons.setPrefSize(300.0, 100.0);
        buttons.setAlignment(Pos.CENTER);
        resultLabel = new Label("");
        VBox bottomPanel = new VBox(buttons, resultLabel);
        bottomPanel.setAlignment(Pos.TOP_CENTER);
        return bottomPanel;
    }

    private double[] getConstructorArgs() {
        ArrayList<Double> result = new ArrayList<>();
        for (Node node: topPanel.getChildren().filtered(node -> node.getClass().equals(TextField.class)))
            result.add(Double.parseDouble(((TextField) node).getText()));
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public void replaceTopPanel(ArrayList<Label> children) {
        topPanel.getChildren().clear();
        for (Label child : children) {
            TextField tf = new TextField();
            tf.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    Double.parseDouble(newValue);
                } catch (NumberFormatException e) {
                    tf.setText(oldValue);
                }
            });
            topPanel.getChildren().addAll(child, tf);
        }
    }

    public void setShapeFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }
}
