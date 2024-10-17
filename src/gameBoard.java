public class gameBoard {
    private char[][] board;

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


    /*

    public void setGamePiece(int num, char XorO) {
        int row = (num - 1) / 3;
        int col = ((num - 1) % 3) * 2; // Multiply by 2 to account for the '|'
        gameBoard[row * 2][col] = XorO; // Multiply row by 2 to account for '-' and '+' rows
        GameStatus.pieceCount++;
    }

 */
}


