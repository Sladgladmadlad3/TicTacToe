
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
}
