package matrix.workingPeoplesImitation.task_2373_Largest_Local_Values_in_a_Matrix;

public class Solution {

    // my solution
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length - 2;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = lagestInSquare(grid, i, j);
            }
        }
        return result;
    }
    private int lagestInSquare(int[][] grid, int y, int x) {
        int max = 0;
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }

    // from editorial
    // Return the maximum values in the 3 x 3 matrix with top-left as (x, y).
    private int findMax(int[][] grid, int x, int y) {
        int maxElement = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                maxElement = Math.max(maxElement, grid[i][j]);
            }
        }

        return maxElement;
    }

    public int[][] largestLocal2(int[][] grid) {
        int N = grid.length;

        int[][] maxLocal = new int[N - 2][N - 2];
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 2; j++) {
                maxLocal[i][j] = findMax(grid, i, j);
            }
        }

        return maxLocal;
    }

    // from walkccc.me
    public int[][] largestLocal3(int[][] grid) {
        final int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; ++i)
            for (int j = 0; j < n - 2; ++j)
                for (int x = i; x < i + 3; ++x)
                    for (int y = j; y < j + 3; ++y)
                        ans[i][j] = Math.max(ans[i][j], grid[x][y]);

        return ans;
    }

}
