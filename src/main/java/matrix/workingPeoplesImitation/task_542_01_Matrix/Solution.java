package matrix.workingPeoplesImitation.task_542_01_Matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    // my solution (повторил решение за GPT)
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = Integer.MAX_VALUE - 10000;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0) {
                    matrix[i][j] = 0;
                } else {
                    if (i > 0) matrix[i][j] = Math.min(matrix[i - 1][j] + 1, matrix[i][j]);
                    if (j > 0) matrix[i][j] = Math.min(matrix[i][j - 1] + 1, matrix[i][j]);
                }

        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                if (mat[i][j] == 0) {
                    matrix[i][j] = 0;
                } else {
                    if (i < m - 1) matrix[i][j] = Math.min(matrix[i + 1][j] + 1, matrix[i][j]);
                    if (j < n - 1) matrix[i][j] = Math.min(matrix[i][j + 1] + 1, matrix[i][j]);
                }

        return matrix;
    }


    // my solution (BFS Approach)
    public int[][] updateMatrix0(int[][] mat) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];
                if (newRow < 0 || newRow == m || newCol < 0 || newCol == n) continue;
                if (mat[newRow][newCol] == Integer.MAX_VALUE) {
                    mat[newRow][newCol] = mat[current[0]][current[1]] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }

    // from GPT (dp Approach)
    public int[][] updateMatrix3(int[][] mat) {
        // Get the dimensions of the input matrix
        int m = mat.length;
        int n = mat[0].length;

        // Initialize the result matrix with maximum values
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize each cell to a large value to represent infinity, avoiding overflow
                result[i][j] = Integer.MAX_VALUE - 10000; // Avoid overflow
            }
        }

        // Top-left to bottom-right pass
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // If the cell has 0, set the distance to 0
                    result[i][j] = 0;
                } else {
                    // Update distance based on the top and left neighbors
                    if (i > 0) {
                        result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                    }
                }
            }
        }

        // Bottom-right to top-left pass
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Update distance based on the bottom and right neighbors
                if (i < m - 1) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }

        // Return the final result matrix with minimum distances
        return result;
    }
    // Explanation:
    //    The DP solution uses two passes: one from the top-left to the bottom-right, and another from the bottom-right to the top-left.
    //    In the first pass, it updates the distances based on the top and left neighbors.
    //    In the second pass, it updates the distances based on the bottom and right neighbors.
    //    The final result matrix contains the minimum distances from each cell to the nearest 0.


    // my solution (slow approach)
    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] matrix = new int[m][n];
        int num = 0;
        boolean bool = true;
        while (bool) {
            num++;
            bool = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == num) {
                        int prev = mat[i][j];
                        int north = i - 1 >= 0 ? mat[i - 1][j] : mat[i][j];
                        int south = i + 1 < m ? mat[i + 1][j] : mat[i][j];
                        int west = j - 1 >= 0 ? mat[i][j - 1] : mat[i][j];
                        int east = j + 1 < n ? mat[i][j + 1] : mat[i][j];
                        matrix[i][j] = Math.min(Math.min(north, south), Math.min(west, east)) + 1;
                        if (prev != matrix[i][j]) bool = true;
                    }
                }
            }
            mat = Arrays.copyOf(matrix, m);
        }
        return matrix;
    }

    // my solution (wrong way)
    public int[][] updateMatrix1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    int north = i - 1 >= 0 ? mat[i - 1][j] : mat[i][j];
                    int south = i + 1 < m ? mat[i + 1][j] : mat[i][j];
                    int west = j - 1 >= 0 ? mat[i][j - 1] : mat[i][j];
                    int east = j + 1 < n ? mat[i][j + 1] : mat[i][j];
                    mat[i][j] = Math.min(Math.min(north, south), Math.min(west, east)) + 1;
                }
            }
        }
        return mat;
    }
}
