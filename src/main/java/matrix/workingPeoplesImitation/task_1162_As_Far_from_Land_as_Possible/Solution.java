package matrix.workingPeoplesImitation.task_1162_As_Far_from_Land_as_Possible;

import java.util.ArrayDeque;
import java.util.Queue;

// my solution
public class Solution {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> border = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    if (isBorder(grid, i, j, 1, -10)) {
                        border.offer(new int[]{i, j});
                    } else {
                        grid[i][j] = -1;
                    }
                }
            }
        }
        int max = -1;
        int level = 0;
        while (!border.isEmpty()) {
            level++;
            max = Math.max(max, level);
            int size = border.size();
            for (int p = 0; p < size; p++) {
                int[] ceil = border.poll();
                for (int[] dir : dirs) {
                    int y = ceil[0] + dir[0];
                    int x = ceil[1] + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }
                    if (grid[y][x] < 0 && isBorder(grid, y, x, -1, level - 1)) {
                        border.offer(new int[]{y, x});
                        grid[y][x] = level;
                    }
                }
            }
        }
        if (max > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == -1) {
                        grid[i][j] = level;
                        max = Math.max(max, grid[i][j]);
                    }
                }
            }
        }
        return max;
    }

    private boolean isBorder(int[][] grid, int i, int j, int target, int neighbour) {
        int n = grid.length;
        boolean similarNeighbour = true;
        for (int[] dir : dirs) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (x < 0 || y < 0 || x >= n || y >= n) {
                continue;
            }
            if (grid[y][x] == target) {
                return true;
            }
            if (grid[y][x] != neighbour) {
                similarNeighbour = false;
            }
        }
        return similarNeighbour;
    }

    // Approach 2 (brute force) (slow)
    public int maxDistance2(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -grid[i][j];
            }
        }
        int level = 1;
        int max = -1;
        boolean madeMove = true;
        while (madeMove) {
            madeMove = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        if (isBorder2(grid, i, j, max)) {
                            grid[i][j] = level;
                            madeMove = true;
                        }
                    }
                }
            }
            if (madeMove) {
                max = level;
            }
            level++;
        }
        return max;
    }

    private final int[][] dirs2 = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean isBorder2(int[][] grid, int i, int j, int target) {
        int n = grid.length;
        for (int[] dir : dirs2) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (x < 0 || y < 0 || x >= n || y >= n) {
                continue;
            }
            if (grid[y][x] == target) {
                return true;
            }
        }
        return false;
    }
}
