public class GameStatus {

    public static int pieceCount = 0;

    /**
     * 
     * @param board
     * @param XorO
     * @return
     */
    /*
    public static boolean checkWin(gameBoard board, char XorO) {
        char[][] boardState = board.getGameBoard();
        //horizontal checks
         for (int i = 0; i < boardState.length; i+=2) {
             int count = 0;
             for (int j = 0; j < boardState[i].length; j+=2) {
                 if (boardState[i][j] == XorO) {
                     count++;
                 }
             }
             if(count == 3) {
                 return true;
             }
        }
        //Vertical checks
        for (int i = 0; i < boardState[0].length; i+=2) {
            int count = 0;
            for (int j = 0; j < boardState.length; j+=2) {
                if (boardState[j][i] == XorO) {
                    count++;
                }
            }
            if(count == 3) {
                return true;
            }
        }
        //Diagonal Checks
        if(boardState[0][0] == XorO && boardState[2][2] == XorO && boardState[4][4] == XorO) {
            return true;
        }

        if(boardState[4][0] == XorO && boardState[2][2] == XorO && boardState[0][4] == XorO) {

            return true;
        }
        return false;
    }

    public static boolean checkDraw() {
        return pieceCount >= 8;
    }
    */

}
