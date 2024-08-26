package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

// from leetcode code sample (7)
public class Solution9 {
    private static final int[][][] DIRECTIONS = {
            {{}, {}},
            {{0, -1}, {0, 1}},   // 1: left and right
            {{-1, 0}, {1, 0}},   // 2: up and down
            {{0, -1}, {1, 0}},   // 3: left and down
            {{0, 1}, {1, 0}},    // 4: right and down
            {{0, -1}, {-1, 0}},  // 5: left and up
            {{0, 1}, {-1, 0}}    // 6: right and up
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, m, n, visited);
    }

    private boolean dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i == m - 1 && j == n - 1) return true;

        visited[i][j] = true;

        for (int[] dir : DIRECTIONS[grid[i][j]]) {
            int ni = i + dir[0], nj = j + dir[1];

            if (isValid(ni, nj, m, n) && !visited[ni][nj] && canConnect(grid[i][j], grid[ni][nj], dir)) {
                if (dfs(grid, ni, nj, m, n, visited)) return true;
            }
        }

        return false;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private boolean canConnect(int current, int next, int[] dir) {
        for (int[] nextDir : DIRECTIONS[next]) {
            if (dir[0] + nextDir[0] == 0 && dir[1] + nextDir[1] == 0) {
                return true;
            }
        }
        return false;
    }
}
