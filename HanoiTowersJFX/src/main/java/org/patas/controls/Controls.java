package org.patas.controls;

import javafx.animation.Animation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import org.patas.Main;

public class Controls extends HBox {
    private Main main;
    private CustomButton playPause = new CustomButton();
    private PlayAnimationInterface playAnimation;
    private PauseAnimationInterface pauseAnimation;

    /**
     * Constructs the Controls Pane
     * @param main Main class
     */
    public Controls(Main main) {
        this.main = main;
        setSpacing(20);
        setPrefHeight(80);
        setAlignment(Pos.CENTER);
        setupNumDisksControls();
        Separator sp = new Separator(Orientation.VERTICAL);
        sp.setPrefWidth(80);
        getChildren().add(sp);
        setupStepControls();
        setAnimationStatus(Animation.Status.PAUSED);
    }

    /**
     * Adds controls to change the number of disks in the Towers Pane
     */
    private void setupNumDisksControls() {
        Label numDisksLbl = new Label("" + main.getNumDisks());
        numDisksLbl.setFont(Font.font(18));
        CustomButton minus = new CustomButton("−", event -> {
            if (main.getNumDisks() > 3)
                main.resetTowers(main.getNumDisks() - 1);
            numDisksLbl.setText("" + main.getNumDisks());
        });
        CustomButton plus = new CustomButton("+", event -> {
            main.resetTowers(main.getNumDisks() + 1);
            numDisksLbl.setText("" + main.getNumDisks());
        });
        getChildren().addAll(minus, numDisksLbl, plus);
    }

    /**
     * Adds the controls to move a step, reset the towers or to play and pause
     */
    private void setupStepControls() {
        getChildren().addAll(
                new CustomButton("←", event -> main.moveStep(Main.StepDirection.PREV)),
                new CustomButton("↻", event -> main.resetTowers(main.getNumDisks())),
                playPause,
                new CustomButton("→", event -> main.moveStep(Main.StepDirection.NEXT))
        );
    }

    /**
     * Sets the functions that control the flow of the animation
     * @param playAnimation An interface with just the play() method
     * @param pauseAnimation An interface with just the pause() method
     */
    public void setAnimationControlFunctions(PlayAnimationInterface playAnimation,
                                             PauseAnimationInterface pauseAnimation) {
        this.playAnimation = playAnimation;
        this.pauseAnimation = pauseAnimation;
    }

    /**
     * Changes the icon and the EventHandler of the playPause button
     * @param animationStatus The current animation status
     */
    public void setAnimationStatus(Animation.Status animationStatus) {
        switch (animationStatus) {
            case RUNNING:
                playPause.reset("⏸", event -> {
                    pauseAnimation.pause();
                    setAnimationStatus(Animation.Status.PAUSED);
                });
                break;
            case PAUSED:
                playPause.reset("▶", event -> {
                    playAnimation.play();
                    setAnimationStatus(Animation.Status.RUNNING);
                });
                break;
            case STOPPED:
                playPause.reset("▶", event -> {
                    main.resetTowers(main.getNumDisks());
                    playAnimation.play();
                    setAnimationStatus(Animation.Status.RUNNING);
                });
        }
    }
}
