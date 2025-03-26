package matrix.workingPeoplesImitation.task_2684_Maximum_Number_of_Moves_in_a_Grid;

import java.util.Arrays;

// my solution
public class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[] available = new boolean[n];
        boolean[] next = new boolean[n];
        Arrays.fill(available, true);
        for (int c = 0; c < m - 1; c++) {
            boolean madeStep = false;
            for (int r = 0; r < n; r++) {
                if (!available[r]) {
                    continue;
                }
                next[r] |= grid[r][c] < grid[r][c + 1];
                madeStep |= next[r];
                if (r > 0) {
                    next[r - 1] |= grid[r][c] < grid[r - 1][c + 1];
                    madeStep |= next[r - 1];
                }
                if (r < n - 1) {
                    next[r + 1] |= grid[r][c] < grid[r + 1][c + 1];
                    madeStep |= next[r + 1];
                }
            }
            if (!madeStep) {
                return c;
            }
            available = next;
            next = new boolean[n];
        }
        return m - 1;
    }
}
