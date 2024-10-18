
import java.util.ArrayList;
import java.util.Random;

public class tictactoeAI {
    public static void easyDifficulty(gameBoard tictacToe) throws InvalidMoveException
    {
        char[][] board = tictacToe.getBoard();
        Random ran = new Random();
        int arrayLength = 0;
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();


        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' '){
                    ArrayList<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    coordinates.add(coordinate);
                    arrayLength = coordinates.size();
                }
            }
        }

        int randomCoordinates = ran.nextInt(arrayLength);

        ArrayList<Integer> coordinate = coordinates.get(randomCoordinates);
        int x = coordinate.get(0);
        int y = coordinate.get(1);

        gameBoard.setGamePiece(x, y, Main.computerPiece, tictacToe);
        coordinates.remove(randomCoordinates);

    }
}
