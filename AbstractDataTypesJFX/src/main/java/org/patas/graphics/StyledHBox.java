package org.patas.graphics;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

/**
* Inherited class from HBox to create stylized horizontal boxes.
*/
class StyledHBox extends HBox {
    /**
     * Class constructor that defines the style of the horizontal boxes.
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
