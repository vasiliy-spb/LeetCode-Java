package matrix.workingPeoplesImitation.task_2536_Increment_Submatrices_by_One;

import static matrix.workingPeoplesImitation.utils.MatrixUtils.printMatrix;

// my solution
public class Solution {

    // with prefix sum
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            matrix[row1][col1]++;
            if (row2 + 1 < n) {
                matrix[row2 + 1][col1]--;
            }
            if (col2 + 1 < n) {
                matrix[row1][col2 + 1]--;
            }
            if (row2 + 1 < n && col2 + 1 < n) {
                matrix[row2 + 1][col2 + 1]++;
            }
//            printMatrix(matrix);
//            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    matrix[i][j] += matrix[i][j - 1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        return matrix;
    }

    // brute force
    public int[][] rangeAddQueries0(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[2]; i++) {
                for (int j = query[1]; j <= query[3]; j++) {
                    matrix[i][j]++;
                }
            }
        }
        return matrix;
    }
}
