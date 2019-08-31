package org.patas.graphics;

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

    public double next() {
        if (!iterator.hasNext()) return 1;
        Algorithm.Step step = iterator.next();
        towers[step.getFrom()].pop();
        towers[step.getTo()].push(step.getDisk());
        return (double) iterator.nextIndex() / numSteps;
    }

    public double prev() {
        if (!iterator.hasPrevious()) return 0;
        Algorithm.Step step = iterator.previous();
        towers[step.getFrom()].push(step.getDisk());
        towers[step.getTo()].pop();
        return (double) iterator.nextIndex() / numSteps;
    }
}
