package org.patas;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        RightBox rightBox = new RightBox();
        LeftBox leftBox = new LeftBox(rightBox);

        HBox root = new HBox(leftBox, new Separator(Orientation.VERTICAL), rightBox);
        root.setPrefSize(800.0, 400.0);
        stage.setScene(new Scene(root));
        stage.setTitle("Area and Perimeter Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
