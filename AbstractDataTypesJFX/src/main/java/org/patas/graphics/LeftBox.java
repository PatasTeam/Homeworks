package org.patas.graphics;

import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import org.patas.shapes.Shape;

public class LeftBox extends VBox {
    private StyledHBox[] panes;

    public LeftBox(RightBox rightBox) {
        super();
        this.setPrefSize(500.0, 400.0);
        panes = new StyledHBox[4];
        panes[0] = new StyledHBox();
        panes[0].getChildren().addAll(Shape.getOptions(this, rightBox));
        this.getChildren().add(panes[0]);
        for (int i = 1; i < panes.length; i++) {
            panes[i] = new StyledHBox();
            this.getChildren().addAll(new Separator(Orientation.HORIZONTAL), panes[i]);
        }
    }

    public StyledHBox getPane(int index) {
        return panes[index];
    }

    public void clearDownFromIndex(int index) {
        for (int i = index; i < panes.length; i++)
            panes[i].getChildren().clear();
    }
}
