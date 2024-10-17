public class GameStatus {
    public static int piecesPlaced = 0;
    private gameBoard board = new gameBoard(); //instance of the gameBoard class

    /**
     * Checks if the game is over (win or draw). Master method.
     * @return True if the game is over, false otherwise.
     */
    public boolean checkWin() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    /**
     * Checks if there is a win on the horizontal axis.
     *
     * @return - True if there is a win on the horizontal axis, false otherwise.
     */
    private boolean checkHorizontal() {
        for(char[] row: board.getBoard()) {
            if(row[0] == row[1] && row[1] == row[2]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a win on the vertical axis.
     * @return - True if there is a win on the vertical axis, false otherwise.
     */
    private boolean checkVertical() {
        for(int i=0; i < (board.getBoard()[0].length); i++) {
            if(board.getBoard()[0][i] == board.getBoard()[1][i] && board.getBoard()[1][i] == board.getBoard()[2][i]) {
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

        return board.getBoard()[0][0] == board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][2] ||
                board.getBoard()[0][2] == board.getBoard()[1][1] && board.getBoard()[1][1] == board.getBoard()[2][0];
    }

    /**
     * Checks if the game is a draw.
     * @return True if the game is a draw, false otherwise.
     */
    public static boolean checkDraw() {
        return piecesPlaced >= 8;
    }

}
