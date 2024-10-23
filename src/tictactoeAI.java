
import java.util.ArrayList;
import java.util.Random;

public class tictactoeAI {
    public static void easyDifficulty(gameBoard tictacToe) throws InvalidMoveException
    {
        char[][] board = tictacToe.getBoard();
        Random ran = new Random();

        ArrayList<ArrayList<Integer>> coordinates = getAvailableCoordinates(board);

        int randomCoordinates = ran.nextInt(coordinates.size());

        if(coordinates.isEmpty()) {
            throw new InvalidMoveException("Empty coordinates");
        }

        ArrayList<Integer> coordinate = coordinates.get(randomCoordinates);
        int x = coordinate.get(0);
        int y = coordinate.get(1);

        gameBoard.setGamePiece(x, y, Main.computerPiece, tictacToe);
        coordinates.remove(randomCoordinates);

    }

    private static ArrayList<ArrayList<Integer>> getAvailableCoordinates (char[][] board) {
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' '){
                    ArrayList<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    coordinates.add(coordinate);
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

    public static void mediumDifficulty(gameBoard tictacToe) throws InvalidMoveException {

        if(checkRows(tictacToe)) {
            return;
        } else if(checkColumns(tictacToe)) {
            return;
        } else if(checkDiagonal(tictacToe)) {
            return;
        } else {
            easyDifficulty(tictacToe);
        }

    }

    // Helper method
    private static boolean checkRows(gameBoard tictacToe) throws InvalidMoveException {
        char[][] board = tictacToe.getBoard();

        for (int i = 0; i < board.length; i++) {
            int playerCount = 0;
            int emptySpotIndex = -1;

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Main.piece) {
                    playerCount++;
                } else if (board[i][j] == ' ') {
                    emptySpotIndex = j;
                }
            }

            if (playerCount == 2 && emptySpotIndex != -1) {
                gameBoard.setGamePiece(i, emptySpotIndex, Main.computerPiece, tictacToe);
                return true;
            }
        }
        return false;
    }

    // Helper Method
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
