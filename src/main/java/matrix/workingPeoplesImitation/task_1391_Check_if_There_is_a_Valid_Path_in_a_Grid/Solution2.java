package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

import java.util.Set;

// my solution
public class Solution2 {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 1 && m == 1) {
            return true;
        }
        int[][] visited = new int[n][m];
        return findPath(grid, 0, 0, visited, n, m);
    }

    private static final int[][][] dirs = {
            {},
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{1, 0}, {0, 1}},
            {{0, -1}, {-1, 0}},
            {{-1, 0}, {0, 1}}
    };

    private boolean findPath(int[][] grid, int i, int j, int[][] visited, int n, int m) {
        visited[i][j] = 1;
        boolean hasPath = false;
        for (int[] dir : dirs[grid[i][j]]) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n) {
                continue;
            }
            if (visited[y][x] > 0) {
                continue;
            }
            if (y == n - 1 && x == m - 1) {
                if (i < y) {
                    if (grid[y][x] == 2 || grid[y][x] == 5 || grid[y][x] == 6) {
                        return true;
                    }
                } else {
                    if (grid[y][x] == 1 || grid[y][x] == 3 || grid[y][x] == 5) {
                        return true;
                    }
                }
            } else {
                if (canMove(grid, i, j, y, x)) {
                    hasPath |= findPath(grid, y, x, visited, n, m);
                }
            }
        }
        return hasPath;
    }
    private static final Set<Integer> aSet = Set.of(2, 3, 4);
    private static final Set<Integer> bSet = Set.of(2, 5, 6);
    private static final Set<Integer> cSet = Set.of(1, 4, 6);
    private static final Set<Integer> dSet = Set.of(1, 3, 5);
    private boolean canMove(int[][] grid, int i, int j, int y, int x) {
        int a = grid[i][j];
        int b = grid[y][x];
        if (j == x) {
            return i < y ? aSet.contains(a) && bSet.contains(b) : aSet.contains(b) && bSet.contains(a);
        } else {
            return j < x ? cSet.contains(a) && dSet.contains(b) : cSet.contains(b) && dSet.contains(a);
        }
    }
}
