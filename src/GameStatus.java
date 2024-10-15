public class GameStatus {

    public static int pieceCount = 0;

    public static void checkBoard(gameBoard board) {
        // Access the private 2D array via the getter method
        char[][] boardState = board.getGameBoard();

        for (char[] row: boardState) {
            for(char cell: row) {
                System.out.print(cell);
            }
            System.out.println();
        }

    }

    public static boolean checkWin(gameBoard board) {
        char[][] boardState = board.getGameBoard();

        if(boardState[0][0] == 'X' && boardState[0][2] == 'X' && boardState[0][4] == 'X') {
            return true;
        } else if (boardState[2][0] == 'X' && boardState[2][2] == 'X' && boardState[2][4] == 'X') {
            return true;
        } else if (boardState[4][0] == 'X' && boardState[4][2] == 'X' && boardState[4][4] == 'X') {
            return true;
        } else if (boardState[0][0] == 'X' && boardState[2][0] == 'X' && boardState[4][0] == 'X') {
            return true;
        } else if (boardState[0][2] == 'X' && boardState[2][2] == 'X' && boardState[4][2] == 'X') {
            return true;
        } else if (boardState[0][4] == 'X' && boardState[2][4] == 'X' && boardState[4][4] == 'X') {
            return true;
        } else if (boardState[0][0] == 'X' && boardState[2][2] == 'X' && boardState[4][4] == 'X') {
            return true;
        } else if (boardState[4][0] == 'X' && boardState[2][2] == 'X' && boardState[0][4] == 'X') {
            return true;
        } else {
            return false;
        }

    }

    public static boolean checkDraw(gameBoard board) {
        return pieceCount <= 8 && !checkWin(board);
    }


}
