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
        /*
        Scanner scanner = new Scanner(System.in);
        gameBoard board = new gameBoard();
        boolean gameOver = false;

        while(!gameOver) {
            // Print the gameboard
            board.printGameBoard();

            //Ask the player for input
            System.out.print("Player X, choose your position (1-9): ");
            int position = scanner.nextInt();

            // Set the piece on the board
            board.setGamePiece(position, 'X');

            if(GameStatus.checkWin(board, 'X')) {
                System.out.println("Player X wins!");
                break;
            } else if (GameStatus.checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            board.printGameBoard();

            System.out.print("Player O, choose your position (1-9): ");
            position = scanner.nextInt();

            // Set the piece on the board
            board.setGamePiece(position, 'O');

            if(GameStatus.checkWin(board, 'O')) {
                System.out.println("Player O wins!");
                gameOver = true;
            } else if (GameStatus.checkDraw()) {
                System.out.println("It's a draw!");
                gameOver = true;
            }

        }

        scanner.close();
        */
    }
    
}


