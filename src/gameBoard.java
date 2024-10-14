public class gameBoard {

    private char[][] gameBoard = {
            {'1', '|', '2','|', '3'},
            {'-', '+', '-', '+', '-'},
            {'4', '|', '5','|', '6'},
            {'-', '+', '-', '+', '-'},
            {'7', '|', '8','|', '9'}
    };

    // Public getter method to access the 2D array
    public char[][] getGameBoard() {
        return gameBoard;
    }

    public void printGameBoard() {
        for (char[] row : gameBoard) {
            for(int i=0; i<row.length; i++) {
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }

    public void setGamePiece(int num, char XorO) {
        int row = (num - 1) / 3;
        int col = ((num - 1) % 3) * 2; // Multiply by 2 to account for the '|'
        gameBoard[row * 2][col] = XorO; // Multiply row by 2 to account for '-' and '+' rows
    }
}


