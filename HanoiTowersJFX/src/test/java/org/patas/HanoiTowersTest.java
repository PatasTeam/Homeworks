package org.patas;

import java.util.ArrayList;

public class HanoiTowersTest {
    public static void main(String[] args) {
        ArrayList<Algorithm.Step> result = Algorithm.solveForSteps(3);
        for (Algorithm.Step step : result)
            System.out.println("Move disk " + step.getDisk() + " from " + step.getFrom() + " to " + step.getTo());
    }
}
