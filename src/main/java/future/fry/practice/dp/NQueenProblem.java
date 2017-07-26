package future.fry.practice.dp;

/**
 *
 * @author ranjeet
 */
public class NQueenProblem {

    private static final int N = 4;

    /*
    The N Queen is the problem of placing N chess 
    queens on an N×N chessboard so that no two queens attack each other. 
     */
    public static void main(String[] args) {
        NQueenProblem queenProblem = new NQueenProblem();
        int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        
        System.out.println(queenProblem.placeQueen(board, 0));

    }

    /*
    Need to check previously placed queen only | Means need to check only
    left side for attacking queens.
     */
    private boolean isSafe(int[][] board, int row, int col) {
        /*
            Check this row on left side
         */
        for (int k = 0; k < col; k++) {
            if (board[row][k] == 1) {
                return false;
            }
        }
        /*
        Check upper diagonal of left side
         */
        int i, j;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /*
        Check lower diagonal on left side
         */
        for (i = row, j = col; i < N && j >= 0; i++, j--) {

            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean placeQueen(int[][] board, int col) {
        /*
        Placed all queen 
         */
        if (col >= N) {
            return true;
        }
        //for col try placing all queen in all row
        for (int i = 0; i < N; i++) {
            //check if we can place queen
            if (isSafe(board, i, col)) {

                //place queen 
                board[i][col] = 1;

                //recursivly place all queen
                if (placeQueen(board, col + 1)) {
                    return true;
                }
                //backtrack 
                board[i][col] = 0;
            }
        }
        return false;
    }
}
