package matrix.workingPeoplesImitation.task_498_Diagonal_Traverse;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    // my solution
    public int[] findDiagonalOrder(int[][] mat) {
        int[] ans = new int[mat.length * mat[0].length];
        int index = 0;
        int y = 0;
        int x = 0;
        int number = 1;
        while (index < ans.length) {
            if (number % 2 == 1) {
                y = Math.min(number - 1, mat.length - 1);
                x = Math.max((number - 1) - (mat.length - 1), 0);
                while (x < mat[0].length && y >= 0) {
                    ans[index++] = mat[y--][x++];
                }
            } else {
                y = Math.max((number - 1) - (mat[0].length - 1), 0);
                x = Math.min(number - 1, mat[0].length - 1);
                while (y < mat.length && x >= 0) {
                    ans[index++] = mat[y++][x--];
                }
            }
            number++;
        }
        return ans;
    }

    // from walkccc.me
    public int[] findDiagonalOrder2(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int[] ans = new int[m * n];
        int d = 1; // left-bottom -> right-top
        int row = 0;
        int col = 0;

        for (int i = 0; i < m * n; ++i) {
            ans[i] = matrix[row][col];
            row -= d;
            col += d;
            // out-of-bounds
            if (row == m) {
                row = m - 1;
                col += 2;
                d = -d;
            }
            if (col == n) {
                col = n - 1;
                row += 2;
                d = -d;
            }
            if (row < 0) {
                row = 0;
                d = -d;
            }
            if (col < 0) {
                col = 0;
                d = -d;
            }
        }

        return ans;
    }

    // from leetcode editorial (Approach 1: Diagonal Iteration and Reversal)
    public int[] findDiagonalOrder3(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }

    // from leetcode editorial (Approach 2: Simulation)
    public int[] findDiagonalOrder4(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N * M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0);
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }

}
