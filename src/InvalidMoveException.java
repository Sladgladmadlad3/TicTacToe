/**
 * Exception thrown when an invalid move is attempted on the Tic-Tac-Toe board.
 */
public class InvalidMoveException extends Exception {
    /**
     * Constructs a new InvalidMoveException with the specified error message.
     *
     * @param message The error message describing the invalid move.
     *
     */
    public InvalidMoveException(String message) {

        super(message); // Pass the error message to the parent Exception class
    }
}

