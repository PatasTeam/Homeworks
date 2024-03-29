package org.patas.graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Disk class extends Rectangle.
 */
class Disk extends Rectangle {
    private int diskNum;

    /**
     * The constructor calls the methods to define the width, height, fill
     * color and the arc of the disk depending on its order
     *
     * @param diskNum Current disk number
     * @param numDisks Number of total disk
     */
    Disk(int diskNum, int numDisks) {
        this.diskNum = diskNum;
        setWidth(getWidth(numDisks));
        setHeight(getHeight(numDisks));
        setFill(getColor(numDisks));
        setArcWidth(getHeight());
        setArcHeight(getHeight());
    }

    /**
     * Receives the total number of disks and defines the height of the disk
     * that are going to be displayed depending on the width of the box, the
     * total number of disks and the number of the current disk
     *
     * @param numDisks Number of disks
     * @return Width of the disk
     */
    private double getWidth(int numDisks) {
        return 80.0 + diskNum * 100.0 / (numDisks - 1);
    }

    /**
     * Receives the numbers of disks to display and returns its height
     * depending on the total height of the box
     *
     * @param numDisks Number of disks
     * @return Height of the disk
     */
    static double getHeight(int numDisks) {
        return Math.min(50.0, 270.0 / numDisks);
    }

    /**
     * Receives the number of disks that are going to be displayed and
     * returns the color that the disk will have depending on the total
     * number of disks and the number of the current disk
     *
     * @param numDisks Number of disks
     * @return Color of the disk
     */
    private Color getColor(int numDisks) {
        double hue = diskNum * 360.0 / numDisks;
        return Color.hsb(hue, 1, 1);
    }
}
