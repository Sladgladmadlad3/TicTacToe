public class gameBoard {

    private char[][] gameBoard = {
            {'1', '|', '2','|', '3'},
            {'-', '+', '-', '+', '-'},
            {'4', '|', '5','|', '6'},
            {'-', '+', '-', '+', '-'},
            {'7', '|', '8','|', '9'}
    };


    public void printGameBoard() {
        for (char[] row : gameBoard) {
            for(int i=0; i<row.length; i++) {
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }

    public void setGamePiece(int num, char XorO) {
        switch(num) {
            case 1:
                gameBoard[0][0] = XorO;
                break;
            case 2:
                gameBoard[0][2] = XorO;
                break;
            case 3:
                gameBoard[0][4] = XorO;
                break;
            case 4:
                gameBoard[2][0] = XorO;
                break;
            case 5:
                gameBoard[2][2] = XorO;
                break;
            case 6:
                gameBoard[2][4] = XorO;
                break;
            case 7:
                gameBoard[4][0] = XorO;
                break;
            case 8:
                gameBoard[4][2] = XorO;
                break;
            case 9:
                gameBoard[4][4] = XorO;
                break;
        }
    }
}


