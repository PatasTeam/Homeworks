package org.patas;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.patas.controls.Controls;
import org.patas.graphics.Towers;

/**
 * Java program to solve Hanoi Towers problem
 *
 * @author Mario Emilio Jiménez Vizcaíno
 * @author Arturo Efrén Jiménez Garibaldy
 * @author Kevin Torres Martínez
 * @version 1.0
 * @since 06-09-2019
 */

public class Main extends Application {
    private int numDisks = 3;
    private VBox root;
    public static Duration STEP_DURATION = Duration.millis(300);
    private Towers towers;
    private ProgressBar progressBar;
    private Controls controls;

    public static void main(String[] args) {
        launch();
    }

    /**
     * start method of the application abstract class
     * @param stage The window that contains Scenes and Nodes javaFX
     */

    @Override
    public void start(Stage stage) {
        controls = new Controls(this);
        setupPlayPause();
        progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(700);
        towers = new Towers(numDisks);
        root = new VBox(controls, progressBar, towers);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 750, 520);
        stage.setScene(scene);
        stage.setTitle("Hanoi Towers Solver");
        stage.show();
    }

    /**
     * resetTowers method to return the towers to their initial state
     * @param numDisks Disks showed in the interface and used to calculate
     *                 the number of steps in the algorithm
     */

    public void resetTowers(int numDisks) {
        this.numDisks = numDisks;
        progressBar.setProgress(0);
        root.getChildren().remove(towers);
        towers = new Towers(numDisks);
        root.getChildren().add(towers);
        setupPlayPause();
    }

    /**
     * Returns the number of disks
     * @return numDisks
     */

    public int getNumDisks() {
        return numDisks;
    }

    /**
     * Method that creates the animation of the solution
     * @param s Get the number of step directions
     */

    public void moveStep(StepDirection s) {
        double oldProgress = progressBar.getProgress();
        double newProgress = s.equals(StepDirection.PREV) ? towers.prev() : towers.next();
        Timeline progressBarAnimation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), oldProgress)),
                new KeyFrame(STEP_DURATION, new KeyValue(progressBar.progressProperty(), newProgress))
        );
        progressBarAnimation.play();
    }

    /**
     * Method to play and pause animation
     */

    private void setupPlayPause() {
        SequentialTransition seq = new SequentialTransition();
        controls.setAnimationControlFunctions(seq::play, seq::pause);
        PauseTransition start = new PauseTransition(Duration.ZERO);
        start.setOnFinished(event -> controls.setAnimationStatus(Animation.Status.RUNNING));
        seq.getChildren().add(start);
        for (int i = 0; i < Math.pow(2, numDisks); i++) {
            PauseTransition p = new PauseTransition(STEP_DURATION);
            p.setOnFinished(event -> moveStep(StepDirection.NEXT));
            seq.getChildren().add(p);
        }
        seq.setOnFinished(event -> controls.setAnimationStatus(Animation.Status.STOPPED));
    }

    public enum StepDirection {
        PREV, NEXT
    }
}
