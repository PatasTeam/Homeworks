package org.patas.graphics;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class StyledHBox extends HBox {
    public StyledHBox(Node... children) {
        super(20.0, children);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(200.0, 100.0);
    }
}
