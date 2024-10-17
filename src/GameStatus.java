public class GameStatus {
    private gameBoard board = new gameBoard(); //instance of the gameBoard class

    /**
     * Checks if the game is over (win or draw). Master method.
     * @return True if the game is over, false otherwise.
     */
    public boolean checkWin() {
        return checkHorizontal(board);
    }

    /**
     * Checks if there is a win on the horizontal axis.
     *
     * @param board - The game board to check for a win.
     * @return - True if there is a win on the horizontal axis, false otherwise.
     */
    private boolean checkHorizontal(gameBoard board) {
        for(char[] row: board.getBoard()) {
            if(row[0] == row[1] && row[1] == row[2]) {
                return true;
            }
        }
        return false;
    }


    private boolean checkVertical() {
        return false;
    }

    private boolean checkDiagonal() {
        return false;
    }

    public boolean checkDraw() {
        return false;
    }

}
