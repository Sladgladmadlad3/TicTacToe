import java.util.Scanner;

public class Main {
    /**
     * Main method to run the Tic-Tac-Toe game.
     * Handles the game loop until a player wins or the game ends in a draw.
     *
     * @param args Command line arguments (not used in this game)
     */
    static char computerPiece;
    static char piece;

    public static void main(String[] args) {
        gameBoard tictacToe = new gameBoard(); // Instance of gameBoard
        GameStatus status = new GameStatus(); // Instance of GameStatus
        char[][] board = tictacToe.getBoard(); // getter method of gameBoard
        Scanner scanner = new Scanner(System.in); // Single instance for all input
        boolean gameOver = false;
        tictacToe.initializeBoard();

        System.out.println("Welcome to TicTacToe!");

        System.out.println("Would you like to be X or O:");
        piece = scanner.next().charAt(0);

        if(piece == 'X') {
            computerPiece = 'O';
        } else {
            computerPiece = 'X';
        }



        while (!gameOver) {
            try {

                System.out.println("Enter the x-coordinate (0-2): ");
                int x = scanner.nextInt();

                System.out.println("Enter the y-coordinate (0-2): ");
                int y = scanner.nextInt();

                gameBoard.setGamePiece(x, y, piece, tictacToe);
                tictacToe.printGameBoard(board);

                if (status.checkWin()) {
                    gameOver = true;
                    break;
                }
            } catch (InvalidMoveException e) {
                // Handle the exception: Invalid Move!
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid move.");
                continue;
            }
            try {
                System.out.println("Now it is the computers turn!");

                tictactoeAI.easyDifficulty(tictacToe);

                tictacToe.printGameBoard(board);
            } catch (Exception e) {
                //This shouldn't happen, but we'll log it just in case
                System.out.println("AI tried an invalid move: " + e.getMessage());
            }
                if(status.checkWin()) {
                    gameOver = true;
                }
        }



    }
    
}


