public class GameStatus {
    public void checkBoard(gameBoard board) {
        // Access the private 2D array via the getter method
        char[][] boardState = board.getGameBoard();

        for (char[] row: boardState) {
            for(char cell: row) {
                System.out.print(cell);
            }
            System.out.println();
        }

    }
}
