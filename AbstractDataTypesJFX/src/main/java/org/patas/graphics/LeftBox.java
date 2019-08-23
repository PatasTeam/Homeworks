package org.patas.graphics;

import javafx.geometry.Orientation;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import org.patas.shapes.Shape;

import java.util.ArrayList;

public class LeftBox extends VBox {
    private StyledHBox[] panes;

    public LeftBox(RightBox rightBox) {
        super();
        this.setPrefSize(500.0, 450.0);
        panes = new StyledHBox[3];
        panes[0] = new StyledHBox();
        panes[0].getChildren().addAll(Shape.getOptions(this, rightBox));
        this.getChildren().add(panes[0]);
        for (int i = 1; i < panes.length; i++) {
            panes[i] = new StyledHBox();
            this.getChildren().addAll(new Separator(Orientation.HORIZONTAL), panes[i]);
        }
    }

    /**
     * Deletes content on every HBox from index down
     *
     * @param index Index of HBox in LeftBox
     */
    public void replaceHBox(int index) {
        for (int i = index; i < panes.length; i++)
            panes[i].getChildren().clear();
    }

    /**
     * Deletes content on every HBox from index down
     * Adds children from ArrayList to HBox at index
     * @param index Index of HBox in LeftBox
     * @param children ArrayList of RadioButtons to add
     */
    public void replaceHBox(int index, ArrayList<RadioButton> children) {
        this.replaceHBox(index);
        this.panes[index].getChildren().addAll(children);
    }
}
