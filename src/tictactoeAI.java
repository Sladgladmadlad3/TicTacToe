/**
 * *For my single-player branch I want to make an AI that has three difficulties
 * Goals: Get more fimiliar with Inheritance and Polymorphism, and also improve problem solving skills.
 *
 * classes:
 * 	- tictactoeAI (Master class)
 * 	*Depending on complexity I might add 3 more classes easy, medium, hard.
 *
 * Tips:
 * ArrayList for coordinates:
 *
 * You could store the coordinates as tuples or objects (like (row, col)) to easily reference both row and column when needed.
 * Instead of removing coordinates each time (since they aren't added back), you can simply not store them unless they are empty.
 *
 * Random selection from available spots:
 *
 * After populating the ArrayList with available spots, you can generate a random index based on the size of the list.
 * Use that random index to pick a coordinate and place the AI's move.
 *
 * Class tictactoeAI {
 * 	difficulityEasy(no parameters for now)
 * 		make a new instance of gameboard
 * 		initialize arraylist cordinate
 * 		loop through gameboard 2D array
 * 			if gameboard[][] == ' '
 * 				store coordinate in arraylist
 * 			else remove coordinate from list
 *
 *
 * 		Random num = coordinate.length
 * 		for nums in num:
 * 			gameboard[][] = coordinate
 *
 * }
 */
import java.util.ArrayList;

public class tictactoeAI {
    public static void easyDifficulty(gameBoard tictacToe) {
        char[][] board = tictacToe.getBoard();
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();


        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' '){
                    ArrayList<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    coordinates.add(coordinate);
                }
            }
        }

        for (ArrayList<Integer> integers : coordinates) {
            System.out.print(integers + " ");
            System.out.println();
        }


    }
}
