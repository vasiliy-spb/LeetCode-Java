package matrix.workingPeoplesImitation.task_2536_Increment_Submatrices_by_One;

import static matrix.workingPeoplesImitation.utils.MatrixUtils.printMatrix;

// from leetcode code sample (1)
public class Solution2 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int mat[][] = new int[n][n];

        // Step 1: Apply difference array technique to mark boundaries
        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            // Mark top-left of the range
            mat[row1][col1] += 1;

            // Mark the bottom-right + 1 of the range to cancel out the increment if it's within bounds
            if (row2 + 1 < n) mat[row2 + 1][col1] -= 1;
            if (col2 + 1 < n) mat[row1][col2 + 1] -= 1;

            // Adjust for the bottom-right corner to not apply twice
            if (row2 + 1 < n && col2 + 1 < n) mat[row2 + 1][col2 + 1] += 1;
        }

        // Step 2: Apply row-wise prefix sum to propagate row-wise increments
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }

        // Step 3: Apply column-wise prefix sum to propagate column-wise increments
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                mat[i][j] += mat[i - 1][j];
            }
        }

        return mat;
    }
}

