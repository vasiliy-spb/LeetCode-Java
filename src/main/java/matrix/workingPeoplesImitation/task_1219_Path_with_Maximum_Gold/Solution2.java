package matrix.workingPeoplesImitation.task_1219_Path_with_Maximum_Gold;

import java.util.HashSet;
import java.util.Set;

// my solution 2
public class Solution2 {
    private final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int totalGold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalGold += grid[i][j];
            }
        }
        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    Set<Integer> visited = new HashSet<>();
                    maxGold = Math.max(maxGold, collectGold(grid, i, j, visited));
                    if (maxGold == totalGold) {
                        return maxGold;
                    }
                }
            }
        }
        return maxGold;
    }

    private int collectGold(int[][] grid, int i, int j, Set<Integer> visited) {
        int key = getKey(i, j, grid[0].length);
        if (visited.contains(key)) {
            return 0;
        }
        visited.add(key);
        int gold = 0;
        for (int[] direction : DIRECTIONS) {
            int y = i + direction[0];
            int x = j + direction[1];
            if (!isValid(y, x, grid)) {
                continue;
            }
            if (grid[y][x] == 0) {
                continue;
            }
            gold = Math.max(gold, collectGold(grid, y, x, new HashSet<>(visited)));
        }
        return gold + grid[i][j];
    }

    private int getKey(int i, int j, int length) {
        return i * length + j;
    }

    private boolean isValid(int y, int x, int[][] grid) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
