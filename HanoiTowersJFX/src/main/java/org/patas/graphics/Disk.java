package org.patas.graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Disk extends Rectangle {
    private int diskNum;

    Disk(int diskNum, int numDisks) {
        this.diskNum = diskNum;
        setWidth(getWidth(numDisks));
        setHeight(getHeight(numDisks));
        setFill(getColor(numDisks));
        setArcWidth(getHeight());
        setArcHeight(getHeight());
    }

    private double getWidth(int numDisks) {
        return 80.0 + diskNum * 100.0 / (numDisks - 1);
    }

    static double getHeight(int numDisks) {
        return Math.min(50.0, 270.0 / numDisks);
    }

    private Color getColor(int numDisks) {
        double hue = diskNum * 360.0 / numDisks;
        return Color.hsb(hue, 1, 1);
    }
}
