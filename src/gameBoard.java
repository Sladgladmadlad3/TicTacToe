public class gameBoard {
    private static char[][] board;

    /**
     * Helping constructor to initialize the game board.
     */
    public gameBoard() {
        board = initializeBoard();
    }

    /**
     * Initializes a 3x3 game board with empty spaces.
     *
     * @return A 2D array representing the game board with empty spaces.
     */
    public char[][] initializeBoard() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
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
     * Used to access the private game board.
     * @return The 2D array representing the game board.
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Sets the game piece at the specified position on the game board.
     *
     * @param x - The x-coordinate (row) of the position.
     * @param y - The y-coordinate (column) of the position.
     */
    public static void setGamePiece(int x, int y, char piece, gameBoard ticTacToe) throws InvalidMoveException
    {
       char[][] gameBoard = ticTacToe.getBoard(); // Access the board

        // Check if the selected cell is already occupied
        if (gameBoard[x][y] != ' ') {
            //Throws an InvalidMoveException
            throw new InvalidMoveException("Invalid move");
        }

        board[x][y] = piece;
        GameStatus.piecesPlaced++;

    }

}
