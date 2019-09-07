package org.patas.controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 * Button with custom styles and constructors to simplify code
 */
class CustomButton extends Button {
    CustomButton() {
        setFont(Font.font(24));
        setPrefSize(54, 54);
    }

    CustomButton(String label, EventHandler<ActionEvent> eventHandler) {
        this();
        setText(label);
        setOnAction(eventHandler);
    }

    void reset(String label, EventHandler<ActionEvent> eventHandler) {
        setText(label);
        setOnAction(eventHandler);
    }
}
