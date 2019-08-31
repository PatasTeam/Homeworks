package org.patas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.patas.controls.Controls;
import org.patas.graphics.Towers;

public class Main extends Application {
    private int numDisks = 3;
    private VBox root;
    private Towers towers;
    private Controls controls;
    private ProgressBar progressBar;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        controls = new Controls(this);
        progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(700);
        towers = new Towers(numDisks);
        root = new VBox(controls, progressBar, towers);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 750, 520);
        stage.setScene(scene);
        stage.show();
    }

    public void resetTowers(int numDisks) {
        this.numDisks = numDisks;
        progressBar.setProgress(0);
        root.getChildren().remove(towers);
        towers = new Towers(numDisks);
        root.getChildren().add(towers);
    }

    public int getNumDisks() {
        return numDisks;
    }

    public Towers getTowers() {
        return towers;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
