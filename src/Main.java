import java.util.Scanner;

public class Main {
    /**
     * Main method to run the Tic-Tac-Toe game.
     * Handles the game loop until a player wins or the game ends in a draw.
     *
     * @param args Command line arguments (not used in this game)
     */
    public static void main(String[] args) {
        gameBoard board = new gameBoard(); // instance of the gameBoard class
        GameStatus gameStatus = new GameStatus(); // instance of the GameStatus class
        board.initializeBoard();
        board.setGamePiece(1, 1);
        board.setGamePiece(2, 2);
        board.setGamePiece(3, 3);
        board.printGameBoard(board.getBoard());
        System.out.println(gameStatus.checkWin());
        System.out.println(gameStatus.checkDraw());

    }
    
}


