package matrix.workingPeoplesImitation.task_1020_Number_of_Enclaves;

import java.util.Arrays;

public class Solution {

    // my solution
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid, grid.length - 1, i);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(grid, i, grid[0].length - 1);
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += grid[i][j];
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }

    // from walkccc.me
    public int numEnclaves2(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        // Remove the lands connected to the edge.
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (i * j == 0 || i == m - 1 || j == n - 1)
                    if (grid[i][j] == 1)
                        dfs2(grid, i, j);

        return Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
    }

    private void dfs2(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;
        if (grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        dfs2(grid, i + 1, j);
        dfs2(grid, i - 1, j);
        dfs2(grid, i, j + 1);
        dfs2(grid, i, j - 1);
    }
}
