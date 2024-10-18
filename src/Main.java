import java.util.Scanner;

public class Main {
    /**
     * Main method to run the Tic-Tac-Toe game.
     * Handles the game loop until a player wins or the game ends in a draw.
     *
     * @param args Command line arguments (not used in this game)
     */
    public static void main(String[] args) {
        gameBoard tictacToe = new gameBoard(); // Instance of gameBoard
        char[][] board = tictacToe.getBoard(); // getter method of gameBoard
        boolean gameOver = false;
        System.out.println("Welcome to TicTacToe!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to be X or O:");
        char piece = scanner.next().charAt(0);

        while (!gameOver) {
            tictacToe.initializeBoard();

            Scanner cord = new Scanner(System.in);

            System.out.println("Enter the X-coordinate (1-3): ");
            int x = cord.nextInt();

            System.out.println("Enter the Y-coordinate (1-3): ");
            int y = cord.nextInt();

            tictacToe.setGamePiece(x, y);
            tictacToe.printGameBoard(board);


        }



    }
    
}


