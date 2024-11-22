/**
 * Handles the status of the Tic-Tac-Toe game, including win and draw detection
 */

public class GameStatus {
    public static int piecesPlaced = 0; // Tracks the total number of pieces placed
    private final char[][] tictactoeBoard = gameBoard.getBoard(); // Reference to the game board
    public static boolean debugMode = false; // Flag to enable or disable debug messages

    /**
     * Checks if the game is over (win or draw).
     * @return True if the game is over, false otherwise.
     */
    public boolean checkWin() {
        return checkHorizontal() || checkVertical() || checkDiagonal() || checkDraw();
    }

    /**
     * Checks if there is a win on the horizontal axis.
     *
     * @return - True if there is a win on the horizontal axis, false otherwise.
     */
    private boolean checkHorizontal() {
        for(char[] row: tictactoeBoard) {
            if (row[0] == Main.computerPiece && row[1] == Main.computerPiece && row[2] == Main.computerPiece) {
                if(debugMode){
                    System.out.println("Computer Wins!");
                }
                return true;
            } else if(row[0] == Main.piece && row[1] == Main.piece && row[2] == Main.piece) {
                if(debugMode){System.out.println("Player Wins!");}
                return true;
            };
        }
        return false;
    }

    /**
     * Checks if there is a win on the vertical axis.
     * @return - True if there is a win on the vertical axis, false otherwise.
     */
    private boolean checkVertical() {
        for(int i=0; i < (tictactoeBoard[0].length); i++) {
            if (tictactoeBoard[0][i] == Main.piece && tictactoeBoard[1][i] == Main.piece && tictactoeBoard[2][i] == Main.piece) {
                if(debugMode){System.out.println("Player Wins!");}
                return true;
            } else if (tictactoeBoard[0][i] == Main.computerPiece && tictactoeBoard[1][i] == Main.computerPiece && tictactoeBoard[2][i] == Main.computerPiece) {
                if(debugMode){
                    System.out.println("Computer Wins!");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a win on the diagonal axis.
     * @return - True if there is a win on the diagonal axis, false otherwise.
     */
    private boolean checkDiagonal() {

        if ((tictactoeBoard[0][0] == Main.piece && tictactoeBoard[1][1] == Main.piece && tictactoeBoard[2][2] == Main.piece) || (tictactoeBoard[0][2] == Main.piece && tictactoeBoard[1][1] == Main.piece && tictactoeBoard[2][0] == Main.piece)) {
            if(debugMode){System.out.println("Player Wins!");}
            return true;
        } else if ((tictactoeBoard[0][0] == Main.computerPiece && tictactoeBoard[1][1] == Main.computerPiece && tictactoeBoard[2][2] == Main.computerPiece || tictactoeBoard[0][2] == Main.computerPiece && tictactoeBoard[1][1] == Main.computerPiece && tictactoeBoard[2][0] == Main.computerPiece)) {
            if(debugMode){System.out.println("Computer Wins!");}
            return true;
        }
        return false;
    }

    /**
     * Checks if the game is a draw.
     * @return True if the game is a draw, false otherwise.
     */
    private boolean checkDraw() {
        if (piecesPlaced == 9) {
            if(debugMode){System.out.println("Draw!");}
            return true;
        }
        return false;
    }

}
