package org.patas;

import java.util.ArrayList;

public class Algorithm {
    public static ArrayList<Step> solveForSteps(int disks) {
        return solveForSteps(disks - 1, 0, 1, 2);
    }

    private static ArrayList<Step> solveForSteps(int disk, int from, int to, int other) {
        ArrayList<Step> result = new ArrayList<>();
        if (disk == 0) {
            result.add(new Step(from, to, disk));
            return result;
        }
        result.addAll(solveForSteps(disk - 1, from, other, to));
        result.add(new Step(from, to, disk));
        result.addAll(solveForSteps(disk - 1, other, to, from));
        return result;
    }

    public static class Step {
        private int from, to, disk;

        Step(int from, int to, int disk) {
            this.from = from;
            this.to = to;
            this.disk = disk;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getDisk() {
            return disk;
        }
    }
}
