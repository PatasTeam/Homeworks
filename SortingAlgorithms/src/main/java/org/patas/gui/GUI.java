package org.patas.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import org.patas.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

public class GUI extends Scene {
    public GUI(Main main) {
        super(new Pane());
        Pane root = new Pane();
        FXMLLoader loader = new FXMLLoader();
        try {
            InputStream fxmlStream = getClass().getResourceAsStream("/user_input.fxml");
            root = (Pane) loader.load(fxmlStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
        GUIController guiController = loader.<GUIController>getController();
        guiController.initialize(main);
        this.setRoot(root);
    }
}
