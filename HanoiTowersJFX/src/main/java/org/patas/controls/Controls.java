package org.patas.controls;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import org.patas.Main;

public class Controls extends HBox {
    private Label numDisksLbl;

    public Controls(Main main) {
        setSpacing(20);
        setPrefHeight(80);
        setAlignment(Pos.CENTER);
        setupNumDisksControls(main);
        Separator sp = new Separator(Orientation.VERTICAL);
        sp.setPrefWidth(80);
        getChildren().add(sp);
        setupStepControls(main);
    }

    private void setupNumDisksControls(Main main) {
        Button plus = new Button("+");
        plus.setFont(Font.font(24));
        plus.setPrefSize(54, 50);
        plus.setOnAction(event -> {
            main.resetTowers(main.getNumDisks() + 1);
            numDisksLbl.setText("" + main.getNumDisks());
        });
        numDisksLbl = new Label("" + main.getNumDisks());
        numDisksLbl.setFont(Font.font(24));
        Button minus = new Button("-");
        minus.setFont(Font.font(24));
        minus.setPrefSize(54, 50);
        minus.setOnAction(event -> {
            if (main.getNumDisks() > 3)
                main.resetTowers(main.getNumDisks() - 1);
            numDisksLbl.setText("" + main.getNumDisks());
        });
        Button reset = new Button("Reset");
        reset.setFont(Font.font(18));
        reset.setOnAction(event -> main.resetTowers(main.getNumDisks()));
        getChildren().addAll(plus, numDisksLbl, minus, reset);
    }

    private void setupStepControls(Main main) {
        Button prev = new Button("Previous step");
        prev.setFont(Font.font(18));
        prev.setOnAction(event -> main.getTowers().prev(main.getProgressBar()));
        Button next = new Button("Next step");
        next.setFont(Font.font(18));
        next.setOnAction(event -> main.getTowers().next(main.getProgressBar()));
        getChildren().addAll(prev, next);
    }
}
