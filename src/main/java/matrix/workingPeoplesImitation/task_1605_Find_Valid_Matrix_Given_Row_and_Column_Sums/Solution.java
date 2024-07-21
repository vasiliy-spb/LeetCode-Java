package matrix.workingPeoplesImitation.task_1605_Find_Valid_Matrix_Given_Row_and_Column_Sums;

import java.util.Arrays;

public class Solution {

    // my solution (after hint from GPT)
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = min;
                colSum[j] -= min;
                rowSum[i] -= min;
            }
        }
        return matrix;
    }

    // from leetcode editorial (Approach 1: Greedy)
    public int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[] currRowSum = new int[N];
        int[] currColSum = new int[M];

        int[][] origMatrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                origMatrix[i][j] = Math.min(
                        rowSum[i] - currRowSum[i],
                        colSum[j] - currColSum[j]
                );

                currRowSum[i] += origMatrix[i][j];
                currColSum[j] += origMatrix[i][j];
            }
        }
        return origMatrix;
    }

    // from leetcode editorial (Approach 2: Space Optimized Greedy)
    public int[][] restoreMatrix3(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[][] origMatrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

                rowSum[i] -= origMatrix[i][j];
                colSum[j] -= origMatrix[i][j];
            }
        }

        return origMatrix;
    }

    // from leetcode editorial (Approach 3: Time + Space Optimized Greedy)
    public int[][] restoreMatrix4(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[][] origMatrix = new int[N][M];
        int i = 0, j = 0;

        while (i < N && j < M) {
            origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= origMatrix[i][j];
            colSum[j] -= origMatrix[i][j];

            if (rowSum[i] == 0) {
                i++;
            } else {
                j++;
            }
        }

        return origMatrix;
    }

}
