/**
 * Represents the Tic-Tac-Toe game board and provides methods for manipulating it.
 */
public class gameBoard {
    private static char[][] board;

    /**
     * Constructor to initialize the game board if it hasn't been initialized yet
     */
    public gameBoard() {
        if (board == null) { // Only initialize once
            board = initializeBoard();
        }
    }

    /**
     * Initializes a 3x3 game board with empty spaces.
     *
     * @return A 2D array representing the game board with empty spaces.
     */
    public char[][] initializeBoard() {
        return new char[][]{
                {'O', ' ', 'X'},
                {'X', 'O', 'O'},
                {' ', ' ', 'X'}
        };
    }

    /**
     * Prints the current state of the game board. With borders and spaces.
     *
     * @param board - The 2D array representing the initialized game board.
     */
    public void printGameBoard(char[][] board) {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char value: row) {
                System.out.print(value + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    /**
     * Returns the current game board
     *
     * @return The 2D array representing the game board.
     */
    public static char[][] getBoard() {
        return board;
    }

    /**
     * Sets the game piece at the specified position on the game board.
     *
     * @param x - The x-coordinate (row) of the position.
     * @param y - The y-coordinate (column) of the position.
     * @param piece - The game piece to place ('X' or 'O')
     * @throws InvalidMoveException If the position is already occupied.
     */
    public static void setGamePiece(int x, int y, char piece) throws InvalidMoveException
    {
        // Check if the selected cell is already occupied
        if (board[x][y] != ' ') {
            throw new InvalidMoveException("Invalid move");
        }

        board[x][y] = piece; // Place the piece
        GameStatus.piecesPlaced++; // Increment the number of pieces placed

    }

    /**
     * Undoes a move by clearing the specified position on the board.
     *
     * @param x The x-coordinate (row) of the position.
     * @param y The y-coordinate (column) of the position
     */
    public static void undoGamePiece(int x, int y) {
        board[x][y] = ' '; // Clear the position
        GameStatus.piecesPlaced--; // Decrement the number of pieces placed
    }

}
