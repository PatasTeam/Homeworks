package org.patas.graphics;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

class Tower extends Pane {
    private int numDisks;
    private Stack<Disk> disks;

    Tower(int numDisks, boolean isInitial) {
        this.numDisks = numDisks;
        disks = new Stack<>();
        setPrefSize(250, 420);
        if (isInitial)
            for (int i = numDisks - 1; i >= 0; i--)
                disks.push(new Disk(i, numDisks));
        render();
    }

    void push(int disk) {
        disks.push(new Disk(disk, numDisks));
        render();
    }

    void pop() {
        disks.pop();
        render();
    }

    private void render() {
        getChildren().clear();
        // Render all disks
        Disk[] disksArr = disks.toArray(new Disk[]{});
        for (int i = 0; i < disksArr.length; i++) {
            disksArr[i].setLayoutY(350 - (i + 1) * disksArr[i].getHeight());
            disksArr[i].setLayoutX((250 - disksArr[i].getWidth()) / 2);
            getChildren().add(disksArr[i]);
        }
        // Render decorations
        Line line = new Line(0, 0, 0, 250);
        line.setLayoutX(125);
        line.setLayoutY(100);
        line.setStrokeWidth(3);
        Rectangle base = new Rectangle(200, 20, Color.BROWN);
        base.setLayoutX(25);
        base.setLayoutY(350);
        base.setStrokeWidth(0);
        getChildren().addAll(line, base);
    }
}
