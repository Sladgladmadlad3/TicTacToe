public class GameStatus {
    public static int piecesPlaced = 0;
    private final gameBoard board = new gameBoard(); //instance of the gameBoard class
    private final char[][] tictactoeBoard = board.getBoard();

    /**
     * Checks if the game is over (win or draw). Master method.
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
                System.out.println("Computer Wins!");
                return true;
            } else if(row[0] == Main.piece && row[1] == Main.piece && row[2] == Main.piece) {
                System.out.println("Player Wins!");
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
                System.out.println("Player Wins!");
                return true;
            } else if (tictactoeBoard[0][i] == Main.computerPiece && tictactoeBoard[1][i] == Main.computerPiece && tictactoeBoard[2][i] == Main.computerPiece) {
                System.out.println("Computer Wins!");
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
            System.out.println("Player Wins!");
            return true;
        } else if ((tictactoeBoard[0][0] == Main.computerPiece && tictactoeBoard[1][1] == Main.computerPiece && tictactoeBoard[2][2] == Main.computerPiece || tictactoeBoard[0][2] == Main.computerPiece && tictactoeBoard[1][1] == Main.computerPiece && tictactoeBoard[2][0] == Main.computerPiece)) {
            System.out.println("Computer Wins!");
            return true;
        }
        return false;
    }

    /**
     * Checks if the game is a draw.
     * @return True if the game is a draw, false otherwise.
     */
    private boolean checkDraw() {
        if (piecesPlaced >= 8) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

}
