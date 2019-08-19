package org.patas.shapes.parallelogram;

import java.util.Scanner;

class Square extends Parallelogram {
    private Square(double side) {
        super("Square", side, side, Math.toRadians(90.0));
    }

}
