package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

// from leetcode code sample (8)
public class Solution10 {
    private int[][][] directions = new int[][][] {
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}},
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return dfs(0, 0, m, n, grid, new boolean[m][n]);
    }

    private boolean dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }

        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        for (int[] d : directions[grid[i][j] - 1]) {
            int x = d[0] + i;
            int y = d[1] + j;

            if (x < 0 || y < 0 || x >= m || y >= n) {
                continue;
            }

            for (int[] nD : directions[grid[x][y] - 1]) {
                int nX = x + nD[0];
                int nY = y + nD[1];

                if (nX == i && nY == j && dfs(x, y, m, n, grid, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
