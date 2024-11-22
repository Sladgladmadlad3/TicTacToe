
import java.util.ArrayList;
import java.util.Random;

/**
 * Handles the AI logic for Tic-Tac-Toe, including the Impossible difficulty using the Minimax algorithm
 */
public class tictactoeAI {

    private static final GameStatus status = new GameStatus();

    /**
     * Places a random available piece on the Tic-Tac-Toe board.
     * Implements the easy difficulty by making random moves
     *
     *
     * @throws InvalidMoveException - if there are no available moves.
     */
    public static void easyDifficulty() throws InvalidMoveException
    {
        char[][] board = gameBoard.getBoard();
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
        gameBoard.setGamePiece(x, y, Main.computerPiece);

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
            easyDifficulty();
        }

    }

    /**
     * Recursive Minimax algorithm to evaluate the best move for the AI
     *
     * @param depth - The current depth of recursion
     * @param isMaximizing True if it's the Maximizing Player's turn, false for Minimizing
     * @return - The best score for the current game status
     * @throws InvalidMoveException
     */
    public static int minimax(int depth, boolean isMaximizing) throws InvalidMoveException {
        char[][] board = gameBoard.getBoard(); //Get shared board instance


        //Base case: check if the game is over
        if(status.checkWin()) {
            return isMaximizing ? -10 + depth : 10 - depth; // Adjust score by depth
        }
        if (GameStatus.piecesPlaced >= 9) {
            return 0; // Draw
        }

        // Recursive case: Simulate moves
        if (isMaximizing) {
            // Simulate Player 1's turn (maximizing)
            int maxScore = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board[i][j] == ' ') { // If the spot is empty
                        gameBoard.setGamePiece(i, j, Main.piece); // Simulate Player move
                        int score = minimax( depth + 1, false); // Recurse for AI
                        gameBoard.undoGamePiece(i, j); // Undo move
                        maxScore = Math.max(maxScore, score);
                    }
                }
            }
            return maxScore;
        } else {
            // Simulate AI turn (Minimizing)
            int minScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j] == ' ') { // If the spot is empty
                        gameBoard.setGamePiece(i, j, Main.computerPiece); // Simulate AI move
                        int score = minimax(depth + 1, true); // Recurse for player
                        gameBoard.undoGamePiece(i, j); // Undo move
                        minScore = Math.min(minScore, score); // Keep the best score
                    }
                }
            }
            return minScore;
        }
    }

    /**
     * Implements impossibleDifficulty logic for TictactoeAI class
     * Uses MinMax Algorithm to make winning impossible for user. Will always draw if player plays optimal
     *
     * @param depth - The depth of recursion (used for scoring adjustments)
     * @throws InvalidMoveException if there are no avaialable moves
     */
    public static void impossibleDifficulty(int depth) throws InvalidMoveException {
        char[][] board = gameBoard.getBoard();
        int bestScore = Integer.MAX_VALUE;
        int bestRow = -1, bestCol = -1;
        // Iterate over all possible moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == ' ') { // Check for empty cells
                    gameBoard.setGamePiece(i, j, Main.computerPiece); // Simulate AI move
                    int score = minimax(depth + 1, true); // Recurse for the Player's turn
                    gameBoard.undoGamePiece(i, j); // Undo the move

                    // Track the move with the lowest score
                    if(score < bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                    System.out.println("Evaluating move: (" + i + ", " + j + "), Score: " + score); //For debugging
                }
            }
        }

        // Place the AI's best move
        if(bestRow != -1 && bestCol != -1) {
            GameStatus.debugMode = true;
            gameBoard.setGamePiece(bestRow, bestCol, Main.computerPiece);
            if(!status.checkWin()) {
                GameStatus.debugMode = false;
            }
        } else {
            throw new InvalidMoveException("No valid moves available\n" + boardToString(board));
        }
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
        char[][] board = gameBoard.getBoard();

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
                gameBoard.setGamePiece(i, emptySpotIndex, Main.computerPiece);
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
        char[][] board = gameBoard.getBoard();

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
                gameBoard.setGamePiece(emptySpotIndex, j, Main.computerPiece);
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
        char[][] board = gameBoard.getBoard();
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
            gameBoard.setGamePiece(emptySpotIndexRow, emptySpotIndexColumn, Main.computerPiece);
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
            gameBoard.setGamePiece(emptySpotIndexRow, emptySpotIndexColumn, Main.computerPiece);
            return true;
        }
        return false;
    }
}
