// Custom exception class for invalid moves
public class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message); // Pass the error message to the parent Exception class
    }
}
