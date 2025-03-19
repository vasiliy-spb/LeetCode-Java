package matrix.workingPeoplesImitation.task_1219_Path_with_Maximum_Gold;

// my solution
public class Solution {
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
                    boolean[][] visited = getNewVisited(n, m);
                    maxGold = Math.max(maxGold, collectGold(grid, i, j, visited));
                    if (maxGold == totalGold) {
                        return maxGold;
                    }
                }
            }
        }
        return maxGold;
    }

    private boolean[][] getNewVisited(int n, int m) {
        return new boolean[n][m];
    }

    private int collectGold(int[][] grid, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
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
            boolean[][] newVisited = getCopyOf(visited);
            gold = Math.max(gold, collectGold(grid, y, x, newVisited));
        }
        return gold + grid[i][j];
    }

    private boolean[][] getCopyOf(boolean[][] visited) {
        int n = visited.length;
        int m = visited[0].length;
        boolean[][] newVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newVisited[i][j] = visited[i][j];
            }
        }
        return newVisited;
    }

    private boolean isValid(int y, int x, int[][] grid) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
