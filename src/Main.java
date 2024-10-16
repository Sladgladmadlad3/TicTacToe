import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
    }
    
}


