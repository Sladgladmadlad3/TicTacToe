
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
        char[][] board = tictacToe.getBoard();
        checkRows(tictacToe);

    }

    private static void checkRows(gameBoard tictacToe) throws InvalidMoveException {
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
            }
        }
    }
}
