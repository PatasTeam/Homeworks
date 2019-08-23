package org.patas.shapes;

/**
 * Exception thrown when the shape of the figure is not possible.
 */
public class InvalidShapeException extends Exception {
    /**
     * Class constructor defining the exception message.
     */
    public InvalidShapeException(String message) {
        super(message);
    }
}
