package org.patas.graphics;

import javafx.geometry.Orientation;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import org.patas.shapes.Shape;

import java.util.ArrayList;

/**
* Inherited class from VBox that defines and changes the content
* inside the left box based on the selected radio element.
*/
public class LeftBox extends VBox {
    private StyledHBox[] panes;

    /**
    * Class constructor defining the amount of horizontal boxes
    * and its content -the radio button options-.
    */
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
     * Clears the content of the selected horizontal box
     * by its index.
     *
     * @param index The window that contains all javaFX objects.
     * @return Nothing.
     */
    public void replaceHBox(int index) {
        for (int i = index; i < panes.length; i++)
            panes[i].getChildren().clear();
    }

    /**
     * Calls the replaceHBox method to clear the content of the
     * horizontal box selected by its index and defines the new
     * content based on the previous selected radio buttons.
     *
     * @param index index of the horizontal box.
     * @param children list containing the radioButton options.
     * @return Nothing.
     */
    public void replaceHBox(int index, ArrayList<RadioButton> children) {
        this.replaceHBox(index);
        this.panes[index].getChildren().addAll(children);
    }
}
