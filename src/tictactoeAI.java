//import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Random;

public class tictactoeAI {
    /**
     * Places a random available piece on the Tic-Tac-Toe board.
     * Implements the easy difficulty by making random moves
     *
     *
     * @param tictacToe - The current game board state.
     * @throws InvalidMoveException - if there are no available moves.
     */
    public static void easyDifficulty(gameBoard tictacToe) throws InvalidMoveException
    {
        char[][] board = tictacToe.getBoard();
        Random random = new Random();

        // Get a list of all available coordinates on the board
        ArrayList<ArrayList<Integer>> coordinates = getAvailableCoordinates(board);

        // Pick a random coordinate from the list of available coordinates
        int randomCoordinates = random.nextInt(coordinates.size());

        // Check if there are no available moves, throw an exception
        if(coordinates.isEmpty()) {
            throw new InvalidMoveException("Empty coordinates - No available moves.\n" + boardToString(board));
        }

        // Get the selected coordinate pair
        ArrayList<Integer> coordinate = coordinates.get(randomCoordinates);
        int x = coordinate.get(0);
        int y = coordinate.get(1);

        // Place the piece at the chosen coordinate
        gameBoard.setGamePiece(x, y, Main.computerPiece, tictacToe);

        // Remove the coordinate from the list of available coordinates
        coordinates.remove(randomCoordinates);

    }

    //Helper method - sends snapshot of game state for error debugging
    private static String boardToString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        sb.append("Board state:\n");
        for (char[] row : board) {
            for(char c : row) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Retrieves a list of available coordinates (i.e., empty spots) on the board
     *
     * @param board - The current game board stat represented das a 2D character array.
     * @return - An ArrayList containing ArrayLists of Integer pairs representing available coordinates.
     */

    //To make things easier I was going to use the pair class. To keep it less convoluted, but the pair Class
    //isn't supported in Java 17.
    private static ArrayList<ArrayList<Integer>> getAvailableCoordinates (char[][] board) {
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' '){
                    ArrayList<Integer> coordinatePair = new ArrayList<>();
                    coordinatePair.add(i);
                    coordinatePair.add(j);
                    coordinates.add(coordinatePair);
                }
            }
        }
        return coordinates;
    }

    // Pseudocode for medium difficulty
    // 1. Initialize counters: playerCounter and emptySpotIndex
    // 2. Loop through each row:
    //    a. If element is playerPiece, increment playerCounter
    //    b. If element is empty, record the position
    // 3. After the loop, check if playerCounter is equal to 2 and there's an empty spot:
    //    a. Place the AI piece in the empty spot to block the player
    // 4. Repeat for columns and diagonals


    /**
     * Implements medium difficulty logic for Tic-Tac-Toe AI.
     * Tries to make moves intelligently by checking rows, columns, and diagonals.
     * Falls back to an easy move if no winning move is found
     *
     * @param tictacToe - The current game board state.
     * @throws InvalidMoveException if there are no available moves.
     */
    public static void mediumDifficulty(gameBoard tictacToe) throws InvalidMoveException {

        // Check if there's a row the computer can complete
        if(checkRows(tictacToe)) {
            return;
        }

        // Check if there's a column the computer can complete
        else if(checkColumns(tictacToe)) {
            return;
        }

        // Check if there's a diagonal the computer can complete
        else if(checkDiagonal(tictacToe)) {
            return;
        }

        // If no immediate winning move, revert to easy difficulty strategy
        else {
            easyDifficulty(tictacToe);
        }

    }

    public static int minimax(gameBoard tictacToe, int depth, boolean isMaximizing) throws InvalidMoveException {
        GameStatus status = new GameStatus();
        char[][] board = tictacToe.getBoard();

        //Base case: check if the game is over
        if(status.checkWin()) {
            if(isMaximizing) {
                return -10 + depth; // Penalize loss for maximizing player
            } else {
                return 10 + depth; // Reward win for minimizing player
            }
        }
        if (GameStatus.piecesPlaced >= 9) {
            return 0;
        }
    }

    /**
     * Implements impossibleDifficulty logic for TictactoeAI class
     * Uses MinMax Algorithm to make winning impossible for user
     *
     * @param tictacToe
     * @param depth
     * @throws InvalidMoveException if there are no avaialable moves
     */
    public static void impossibleDifficulty(gameBoard tictacToe, int depth) throws InvalidMoveException {

    }

    // Helper method

    /**
     * Checks all rows to determine if there is an opportunity to complete a row.
     * If a winning move is found, the piece is placed there.
     *
     *
     * @param tictacToe The current game board state.
     * @return true if a winning move is made, false otherwise
     * @throws InvalidMoveException if an invalid move is attempted
     */
    //Tip - Optimization: Using a named constant instead of hardcoding values like 2 can help improve the readability
    //and maintainability of the code.
    private static boolean checkRows(gameBoard tictacToe) throws InvalidMoveException {
        char[][] board = tictacToe.getBoard();

        // Loop through each row to check for a possible win
        for (int i = 0; i < board.length; i++) {
            int playerCount = 0; // Tracks number of player pieces
            int emptySpotIndex = -1; // Tracks empty spot index in the row

            // Loop through each column of the row
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Main.piece) {
                    playerCount++;
                } else if (board[i][j] == ' ') {
                    emptySpotIndex = j;
                }
            }

            // If there are two player pieces and an empty spot, make a move.
            if (playerCount == 2 && emptySpotIndex != -1) {
                gameBoard.setGamePiece(i, emptySpotIndex, Main.computerPiece, tictacToe);
                return true;
            }
        }
        return false;
    }

    // Helper Method

    /**
     * Checks all columns to determine if there is an opportunity to complete a column.
     * If a winning move is found, the pieces is place there.
     *
     * @param tictacToe The current game board state.
     * @return true if a winning move is made, false otherwise.
     * @throws InvalidMoveException if an invalid move is attempted
     */
    private static boolean checkColumns(gameBoard tictacToe) throws InvalidMoveException {
        char[][] board = tictacToe.getBoard();

        for (int j = 0; j < board[0].length; j++) {
            int playerCount = 0;
            int emptySpotIndex = -1;

            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == Main.piece) {
                    playerCount++;
                } else if (board[i][j] == ' ') {
                    emptySpotIndex = i;
                }
            }

            if (playerCount == 2 && emptySpotIndex != -1) {
                gameBoard.setGamePiece(emptySpotIndex, j, Main.computerPiece, tictacToe);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks both diagonals to determine if there is an opportunity to complete a diagonal.
     * If a winning move is found, the piece is placed there.
     *
     * @param tictacToe The current game board state.
     * @return ture if a winning move is made, false otherwise
     * @throws InvalidMoveException if an invalid move is attempted.
     */
    private static boolean checkDiagonal(gameBoard tictacToe) throws InvalidMoveException {
        char[][] board = tictacToe.getBoard();
        int playerCount = 0;
        int emptySpotIndexRow = -1;
        int emptySpotIndexColumn = -1;

        //Check top-left to bottom-right diagonal
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == Main.piece) {
                playerCount++;
            } else if (board[i][i] == ' ') {
                emptySpotIndexRow = i;
                emptySpotIndexColumn = i;
            }
        }

        if(playerCount == 2 && emptySpotIndexRow != -1) {
            gameBoard.setGamePiece(emptySpotIndexRow, emptySpotIndexColumn, Main.computerPiece, tictacToe);
            return true;
        }

        // Check top-right to bottom-left diagonal
        for (int i = 0; i < board.length; i++) {
            int j = board[i].length - 1 - i;
            if (board[i][j] == Main.piece) {
                playerCount++;
            } else if (board[i][j] == ' ') {
                emptySpotIndexRow = i;
                emptySpotIndexColumn = j;
            }
        }

        if(playerCount == 2 && emptySpotIndexRow != -1) {
            gameBoard.setGamePiece(emptySpotIndexRow, emptySpotIndexColumn, Main.computerPiece, tictacToe);
            return true;
        }
        return false;
    }
}
