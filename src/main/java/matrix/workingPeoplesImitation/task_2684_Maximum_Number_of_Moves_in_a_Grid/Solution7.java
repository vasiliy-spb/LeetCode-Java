package matrix.workingPeoplesImitation.task_2684_Maximum_Number_of_Moves_in_a_Grid;

// from leetcode code sample (1)
public class Solution7 {
    int max = 0;

    public void DFS(int i, int j, int[][] grid, int step) {
        max = Math.max(max, step);
        if (j == grid[0].length - 1 || max == grid[0].length - 1)
            return;

        for (int delta = -1; delta <= 1; delta++) {
            int next = i + delta;
            if (next < 0 || next >= grid.length) continue;
            if (grid[next][j + 1] > grid[i][j]) {
                DFS(next, j + 1, grid, step + 1);
                if (max == grid[0].length - 1)
                    break;
            }
        }
        grid[i][j] = 0;
    }

    public int maxMoves(int[][] grid) {
        if (grid[0].length <= 1) return 0;
        for (int i = 0; i < grid.length; i++) {
            DFS(i, 0, grid, 0);
        }
        return max;
    }
}
