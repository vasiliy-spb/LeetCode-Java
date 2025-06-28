package matrix.workingPeoplesImitation.task_2428_Maximum_Sum_of_an_Hourglass;

public class Solution {

    // my solution
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prefixSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
                prefixSum[i][j] += grid[i][j];
            }
        }
        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 2; j < m; j++) {
                int currentSum;
                if (j > 2) {
                    currentSum = (prefixSum[i][j] - prefixSum[i][j - 3]) + (prefixSum[i + 2][j] - prefixSum[i + 2][j - 3] + grid[i + 1][j - 1]);
                } else {
                    currentSum = prefixSum[i][j] + prefixSum[i + 2][j] + grid[i + 1][j - 1];
                }
                sum = Math.max(sum, currentSum);
            }
        }
        return sum;
    }

    // from walkccc.me
    public int maxSum2(int[][] grid) {
        int ans = 0;

        for (int i = 1; i + 1 < grid.length; ++i)
            for (int j = 1; j + 1 < grid[0].length; ++j)
                ans = Math.max(ans, grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + grid[i][j] +
                        grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1]);

        return ans;
    }

}
