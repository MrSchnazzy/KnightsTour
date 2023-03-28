/* Eli Tisor
 * KnightTour.java
 * CSCI-310 Data Structures
 * HW 02 - Knight's Tour
 */

/**
 *
 * @author et0740575
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KnightTour {
    public static final int E = 8;
    
    public static void main(String[] args) {
        int[][] board = new int[E][E];
        int[] row = {2,1,-1,-2,-2,-1,1,2};
        int[] col = {-1,-2,-2,-1,1,2,2,1};
        int steps = 1;
        int currentRow = 0;
        int currentCol = 0;
        Random rand = new Random();
        
        for (int i = 0; i < E; i++){
            for (int j = 0; j < E; j++){
                board[i][j] = 0;
            }
        }
        
        board[0][0] = steps;
          
        while (steps < E * E) {
            List<int[]> possibleMoves = getPossibleMoves(currentRow, currentCol, row, col, board);
            if (possibleMoves.isEmpty())
                break;
           
            int[] nextMove = possibleMoves.get(rand.nextInt(possibleMoves.size()));
            currentRow = nextMove[0];
            currentCol = nextMove[1];
            board[currentRow][currentCol] = ++steps;
        }
        
        for (int i = 0; i < E; i++){
            for (int j = 0; j < E; j++){
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Moves made: " + steps);
    }
    
    static boolean inBounds(int row, int col) {
        return ((row >= 0 && row < E) && (col >= 0 && col < E));
    }
    
    static List<int[]> getPossibleMoves(int currentRow, int currentCol, int[] row, int[] col, int[][] board) {
        List<int[]> possibleMoves = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            int nextRow = currentRow + row[i];
            int nextCol = currentCol + col[i];
            if (inBounds(nextRow, nextCol) && board[nextRow][nextCol] == 0) {
                possibleMoves.add(new int[] {nextRow, nextCol});
            }
        }
        return possibleMoves;
    }
}

