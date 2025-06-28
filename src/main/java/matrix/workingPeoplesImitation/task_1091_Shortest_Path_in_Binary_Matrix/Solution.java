package matrix.workingPeoplesImitation.task_1091_Shortest_Path_in_Binary_Matrix;

import java.util.ArrayDeque;
import java.util.Queue;

// my solution
public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -grid[i][j];
            }
        }
        return findShortestPath(grid, n);
    }
    private final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private int findShortestPath(int[][] grid, int n) {
        if (grid[0][0] < 0 || grid[n - 1][n - 1] < 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = -1;
        int level = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] ceil = queue.poll();
                for (int[] dir : dirs) {
                    int y = ceil[0] + dir[0];
                    int x = ceil[1] + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n || grid[y][x] < 0) {
                        continue;
                    }
                    if (y == n - 1 && x == n - 1) {
                        return level;
                    }
                    queue.offer(new int[]{y, x});
                    grid[y][x] = -1;
                }
            }
            level++;
        }
        return -1;
    }
}
