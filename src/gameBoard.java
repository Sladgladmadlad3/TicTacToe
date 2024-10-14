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
}


