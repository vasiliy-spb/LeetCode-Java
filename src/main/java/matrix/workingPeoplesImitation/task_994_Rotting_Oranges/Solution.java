package matrix.workingPeoplesImitation.task_994_Rotting_Oranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int orangeCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    orangeCount++;
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            if (orangeCount <= 0) return level;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] rottenOrange = queue.poll();
                if (grid[rottenOrange[0]][rottenOrange[1]] == 2) {
                    for (int[] direction : directions) {
                        int[] orange = new int[]{rottenOrange[0] + direction[0], rottenOrange[1] + direction[1]};
                        orangeCount -= rotOrange(queue, grid, orange);
                    }
                }
            }
            level++;
        }
        return orangeCount > 0 ? -1 : level;
    }

    private int rotOrange(Queue<int[]> queue, int[][] grid, int[] orange) {
        if (orange[0] < 0 || orange[0] >= grid.length || orange[1] < 0 || orange[1] >= grid[0].length) return 0;
        if (grid[orange[0]][orange[1]] == 1) {
            grid[orange[0]][orange[1]] = 2;
            queue.offer(orange);
            return 1;
        }
        return 0;
    }
}
