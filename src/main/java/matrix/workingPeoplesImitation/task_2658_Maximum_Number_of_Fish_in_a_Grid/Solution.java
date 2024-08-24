package matrix.workingPeoplesImitation.task_2658_Maximum_Number_of_Fish_in_a_Grid;

public class Solution {
    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    int current = dfs(grid, i, j);
                    max = Math.max(max, current);
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int sum = grid[i][j];
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            sum += dfs(grid, i + dir[0], j + dir[1]);
        }
        return sum;
    }
}
