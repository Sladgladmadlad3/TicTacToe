import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        gameBoard board = new gameBoard();
        board.printGameBoard();
        board.setGamePiece(3,'X');
        board.setGamePiece(7,'O');
        board.printGameBoard();
    }
    
}


