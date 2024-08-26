package matrix.workingPeoplesImitation.task_2017_Grid_Game;

import static matrix.workingPeoplesImitation.utils.MatrixUtils.printMatrix;

// my solution
public class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] dp = new long[2][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j + 1] = grid[i][j] + dp[i][j];
            }
        }

        int index = 0;
        int pivot = 0;
        long max = Long.MAX_VALUE;
        while (pivot < n) {
            long a = dp[0][n] - dp[0][pivot + 1];
            long b = dp[1][pivot] - dp[1][0];
            if (Math.max(a, b) < max) {
                max = Math.max(a, b);
                index = pivot;
            }
            pivot++;
        }
        for (int i = 0; i <= index; i++) {
            grid[0][i] = 0;
        }
        for (int i = index; i < grid[0].length; i++) {
            grid[1][i] = 0;
        }

        long ans1 = 0;
        for (int num : grid[0]) {
            ans1 += num;
        }
        long ans2 = 0;
        for (int num : grid[1]) {
            ans2 += num;
        }

        return Math.max(ans1, ans2);
    }

    // with log
    public long gridGame0(int[][] grid) {
        System.out.println();
        printMatrix(grid, "\t");

        int n = grid[0].length;
        long[][] dp = new long[2][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j + 1] = grid[i][j] + dp[i][j];
            }
        }
        System.out.println();
        printMatrix(dp, "\t");

        int index = 0;
        int pivot = 0;
        long max = Long.MAX_VALUE;
        while (pivot < n) {
            long a = dp[0][n] - dp[0][pivot + 1];
            long b = dp[1][pivot] - dp[1][0];
            if (Math.max(a, b) < max) {
                max = Math.max(a, b);
                index = pivot;
            }
            pivot++;
        }
        System.out.println("index = " + index);

        long remove = 0;
        for (int i = 0; i <= index; i++) {
            remove += grid[0][i];
            grid[0][i] = 0;
        }
        for (int i = index; i < grid[0].length; i++) {
            remove += grid[1][i];
            grid[1][i] = 0;
        }
        System.out.println();
        System.out.println("remove = " + remove);
        System.out.println();
        printMatrix(grid, "\t");

        long ans1 = 0;
        for (int num : grid[0]) {
            ans1 += num;
        }
        long ans2 = 0;
        for (int num : grid[1]) {
            ans2 += num;
        }

        return Math.max(ans1, ans2);
    }
}
