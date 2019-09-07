package org.patas;

import java.util.ArrayList;

/**
 * Recursive algorithm to solve Hanoi Towers problem.
 */

public class Algorithm {
    /**
     * Method calls a private one with the same
     * name and solves for n disks.
     *
     * @param disks Number of disks
     * @return Steps to solve the recursion
     */
    public static ArrayList<Step> solveForSteps(int disks) {
        return solveForSteps(disks - 1, 0, 1, 2);
    }

    /**
     * Recursive method that builds an ArrayList of Steps
     *
     * @param disk Disk to move
     * @param from Index of the tower that has the disk
     * @param to Index of tower that will receive the disk
     * @param other Index of other tower
     * @return ArrayList of Steps
     */
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

    /**
     * Static class that defines the direction of the disk
     * Has information regarding the size of the disk,
     * where did it come from and where it is moved to
     */
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
