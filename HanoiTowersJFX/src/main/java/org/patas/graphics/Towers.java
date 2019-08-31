package org.patas.graphics;

import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import org.patas.Algorithm;

import java.util.ArrayList;
import java.util.ListIterator;

public class Towers extends HBox {
    private Tower[] towers;
    private int numSteps;
    private ListIterator<Algorithm.Step> iterator;

    public Towers(int numDisks) {
        towers = new Tower[3];
        towers[0] = new Tower(numDisks, true);
        towers[1] = new Tower(numDisks, false);
        towers[2] = new Tower(numDisks, false);
        this.getChildren().addAll(towers);
        this.setPrefSize(750, 420);
        ArrayList<Algorithm.Step> steps = Algorithm.solveForSteps(numDisks);
        numSteps = steps.size();
        iterator = steps.listIterator();
    }

    public void next(ProgressBar progressBar) {
        if (!iterator.hasNext()) return;
        Algorithm.Step step = iterator.next();
        towers[step.getFrom()].pop();
        towers[step.getTo()].push(step.getDisk());
        progressBar.setProgress(((double) iterator.nextIndex()) / numSteps);
    }

    public void prev(ProgressBar progressBar) {
        if (!iterator.hasPrevious()) return;
        Algorithm.Step step = iterator.previous();
        towers[step.getFrom()].push(step.getDisk());
        towers[step.getTo()].pop();
        progressBar.setProgress(((double) iterator.nextIndex()) / numSteps);
    }
}
