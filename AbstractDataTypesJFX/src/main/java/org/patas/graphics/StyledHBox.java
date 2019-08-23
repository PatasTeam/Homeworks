package org.patas.graphics;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

class StyledHBox extends HBox {
    /**
     * Creates an HBox with different default styles
     *
     * @param children Nodes to add
     */
    StyledHBox(Node... children) {
        super(20.0, children);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(200.0, 150.0);
    }
}
