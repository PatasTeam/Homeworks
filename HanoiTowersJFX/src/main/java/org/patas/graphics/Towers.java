package org.patas.graphics;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.patas.Algorithm;
import org.patas.Main;

import java.util.ArrayList;
import java.util.ListIterator;

public class Towers extends Pane {
    private int[] towerSizes;
    private Disk[] disks;
    private int numSteps;
    private ListIterator<Algorithm.Step> iterator;

    /**
     *
     * @param numDisks Number of disks
     */
    public Towers(int numDisks) {
        towerSizes = new int[3];
        generateDisks(numDisks);
        this.setPrefSize(750, 420);
        ArrayList<Algorithm.Step> steps = Algorithm.solveForSteps(numDisks);
        numSteps = steps.size();
        iterator = steps.listIterator();
        renderDecorations();
    }

    private void renderDecorations() {
        for (int i = 0; i < 3; i++) {
            double lineX = 125 + i * 250;
            Line line = new Line(lineX, 60, lineX, 350);
            line.setStrokeWidth(3);
            double baseX = 25 + i * 250;
            Rectangle base = new Rectangle(baseX, 350, 200, 20);
            base.setFill(Color.BROWN);
            base.setStrokeWidth(0);
            getChildren().addAll(line, base);
        }
    }

    private void generateDisks(int numDisks) {
        disks = new Disk[numDisks];
        for (int i = numDisks - 1; i >= 0; i--) {
            disks[i] = new Disk(i, numDisks);
            disks[i].setTranslateY(getNextDiskY(0));
            disks[i].setTranslateX((250 - disks[i].getWidth()) / 2);
            towerSizes[0]++;
        }
        getChildren().addAll(disks);
    }

    private double getNextDiskY(int tower) {
        return 350 - (towerSizes[tower] + 1) * Disk.getHeight(disks.length);
    }

    private TranslateTransition buildTransition(int disk, int from, int to) {
        TranslateTransition tt = new TranslateTransition(Main.STEP_DURATION, disks[disk]);
        tt.setByX(250 * (to - from));
        tt.setToY(getNextDiskY(to));
        return tt;
    }

    public double next() {
        if (!iterator.hasNext()) return 1;
        Algorithm.Step step = iterator.next();
        buildTransition(step.getDisk(), step.getFrom(), step.getTo()).play();
        towerSizes[step.getFrom()]--;
        towerSizes[step.getTo()]++;
        return (double) iterator.nextIndex() / numSteps;
    }

    public double prev() {
        if (!iterator.hasPrevious()) return 0;
        Algorithm.Step step = iterator.previous();
        buildTransition(step.getDisk(), step.getTo(), step.getFrom()).play();
        towerSizes[step.getTo()]--;
        towerSizes[step.getFrom()]++;
        return (double) iterator.nextIndex() / numSteps;
    }
}
