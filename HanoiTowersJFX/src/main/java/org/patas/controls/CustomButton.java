package org.patas.controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

class CustomButton extends Button {
    CustomButton() {
        setFont(Font.font(24));
        setPrefSize(54, 54);
    }

    CustomButton(String label, EventHandler<ActionEvent> value) {
        this();
        setText(label);
        setOnAction(value);
    }

    void reset(String label, EventHandler<ActionEvent> value) {
        setText(label);
        setOnAction(value);
    }
}
