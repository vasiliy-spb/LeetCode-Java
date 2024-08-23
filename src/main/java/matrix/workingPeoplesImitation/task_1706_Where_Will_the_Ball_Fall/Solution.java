package matrix.workingPeoplesImitation.task_1706_Where_Will_the_Ball_Fall;

public class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            ans[i] = fallBall(grid, i);
        }
        return ans;
    }

    private int fallBall(int[][] grid, int i) {
        for (int[] row : grid) {
            if (i == 0 && row[0] == -1) {
                return -1;
            } else if (i == row.length - 1 && row[row.length - 1] == 1) {
                return -1;
            } else if (row[i] == 1 && row[i + 1] == -1) {
                return -1;
            } else if (row[i] == -1 && row[i - 1] == 1) {
                return -1;
            } else {
                i += row[i];
            }
        }
        return i;
    }
}
