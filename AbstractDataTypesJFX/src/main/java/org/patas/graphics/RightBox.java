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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class RightBox extends VBox {
    private VBox topPanel;
    private Constructor shapeConstructor;
    private Label resultLabel;

    public RightBox() {
        this.setPrefSize(300.0, 450.0);
        topPanel = new VBox(10.0);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setPrefHeight(200.0);
        topPanel.setPadding(new Insets(10.0));

        VBox bottomPanel = setupBottomPanel();
        this.getChildren().addAll(topPanel, new Separator(Orientation.HORIZONTAL), bottomPanel);
    }

    private VBox setupBottomPanel() {
        Button calcArea = new Button("Calculate Area");
        calcArea.setOnAction(event -> {
            try {
                Shape shape = (Shape) shapeConstructor.newInstance(getConstructorArgs());
                resultLabel.setText("Area: " + shape.calcArea());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        Button calcPeri = new Button("Calculate Perimeter");
        calcPeri.setOnAction(event -> {
            try {
                Shape shape = (Shape) shapeConstructor.newInstance(getConstructorArgs());
                resultLabel.setText("Perimeter: " + shape.calcPerimeter());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        HBox buttons = new HBox(10.0, calcArea, calcPeri);
        buttons.setPrefSize(300.0, 100.0);
        buttons.setAlignment(Pos.CENTER);
        resultLabel = new Label("Result: 100000");
        VBox bottomPanel = new VBox(buttons, resultLabel);
        bottomPanel.setAlignment(Pos.TOP_CENTER);
        return bottomPanel;
    }

    private Object[] getConstructorArgs() {
        ArrayList<Object> result = new ArrayList<>();
        for (Node node: topPanel.getChildren().filtered(node -> node.getClass().equals(TextField.class)))
            result.add(Double.parseDouble(((TextField) node).getText()));
        return result.toArray();
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

    public void setShapeConstructor(Constructor shapeConstructor) {
        this.shapeConstructor = shapeConstructor;
    }
}
