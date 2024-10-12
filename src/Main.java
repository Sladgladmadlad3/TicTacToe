public class Main {
    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ','|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ','|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ','|', ' '}
        };

        for (char[] row : gameBoard) {
            for(int i=0; i<row.length; i++) {
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }
}