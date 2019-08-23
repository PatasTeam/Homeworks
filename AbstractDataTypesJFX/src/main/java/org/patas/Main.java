package org.patas;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;

/**
* <h1>Area and Perimeter Calculator</h1>
* The area and perimeter calculator program
* implements an application that calculates
* the area and perimeter of some geometric
* plane shapes.
*
* @author  Mario Emilio Jiménez Vizcaíno
* @author  Arturo Efrén Jiménez Garibaldy
* @author  Kevin Torres Martínez
* @version 1.0
* @since   22-08-2019
*/
public class Main extends Application {
    /**
    * Start method of the application
    * class that shows the stage.
    *
    * @param stage The window that contains all javaFX objects.
    */
    @Override
    public void start(Stage stage) {
        // The GUI is divided in two main sections
        RightBox rightBox = new RightBox();
        LeftBox leftBox = new LeftBox(rightBox);

        // The left box has three horizontal separators
        // The right box has two horizontal separators
        HBox root = new HBox(leftBox, new Separator(Orientation.VERTICAL), rightBox);
        root.setPrefSize(800.0, 450.0);
        stage.setScene(new Scene(root));
        stage.setTitle("Area and Perimeter Calculator");
        stage.show();
    }

    /**
    * Main method which launches the application
    * using the launch method.
    *
    * @param args Unused.
    */
    public static void main(String[] args) {
        launch();
    }
}
