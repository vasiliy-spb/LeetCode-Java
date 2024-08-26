package matrix.workingPeoplesImitation.task_1391_Check_if_There_is_a_Valid_Path_in_a_Grid;

import java.util.Set;

// my solution
public class Solution {
    public boolean hasValidPath(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return true;
        }
        int[][] visited = new int[grid.length][grid[0].length];
        return findPath(grid, 0, 0, visited);
    }

    private final int[][][] dirs = {
            {},
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{1, 0}, {0, 1}},
            {{0, -1}, {-1, 0}},
            {{-1, 0}, {0, 1}}
    };

    private boolean findPath(int[][] grid, int i, int j, int[][] visited) {
        visited[i][j] = 1;
        boolean hasPath = false;
        for (int[] dir : dirs[grid[i][j]]) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length) {
                continue;
            }
            if (visited[y][x] > 0) {
                continue;
            }
            if (y == grid.length - 1 && x == grid[0].length - 1) {
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
                    hasPath |= findPath(grid, y, x, visited);
                }
            }
        }
        return hasPath;
    }

    private boolean canMove(int[][] grid, int i, int j, int y, int x) {
        int a = grid[i][j];
        int b = grid[y][x];
        if (i < y) {
            switch (a) {
                case 2:
                    if (b == 2 || b == 5 || b == 6) return true;
                case 3:
                    if (b == 2 || b == 5 || b == 6) return true;
                case 4:
                    if (b == 2 || b == 5 || b == 6) return true;
                default:
                    return false;
            }
        }
        if (i > y) {
            switch (a) {
                case 2:
                    if (b == 2 || b == 3 || b == 4) return true;
                case 5:
                    if (b == 2 || b == 3 || b == 4) return true;
                case 6:
                    if (b == 2 || b == 3 || b == 4) return true;
                default:
                    return false;
            }
        }
        if (j < x) {
            switch (a) {
                case 1:
                    if (b == 1 || b == 3 || b == 5) return true;
                case 4:
                    if (b == 1 || b == 3 || b == 5) return true;
                case 6:
                    if (b == 1 || b == 3 || b == 5) return true;
                default:
                    return false;
            }
        }
        switch (a) {
            case 1:
                if (b == 1 || b == 4 || b == 6) return true;
            case 3:
                if (b == 1 || b == 4 || b == 6) return true;
            case 5:
                if (b == 1 || b == 4 || b == 6) return true;
            default:
                return false;
        }
    }

    private boolean canMove2(int[][] grid, int i, int j, int y, int x) {
        int a = grid[i][j];
        int b = grid[y][x];
        if (j == x) {
            return i < y ? Set.of(2, 3, 4).contains(a) && Set.of(2, 5, 6).contains(b) : Set.of(2, 3, 4).contains(b) && Set.of(2, 5, 6).contains(a);
        } else {
            return j < x ? Set.of(1, 4, 6).contains(a) && Set.of(1, 3, 5).contains(b) : Set.of(1, 4, 6).contains(b) && Set.of(1, 3, 5).contains(a);
        }
    }

    private boolean canMove1(int[][] grid, int i, int j, int y, int x) {
        int a = grid[i][j];
        int b = grid[y][x];
        Set<Integer> aSet = null;
        Set<Integer> bSet = null;
        if (i < y) {
            aSet = Set.of(2, 3, 4);
            bSet = Set.of(2, 5, 6);
        }
        if (i > y) {
            aSet = Set.of(2, 5, 6);
            bSet = Set.of(2, 3, 4);
        }
        if (j < x) {
            aSet = Set.of(1, 4, 6);
            bSet = Set.of(1, 3, 5);
        }
        if (j > x) {
            aSet = Set.of(1, 3, 5);
            bSet = Set.of(1, 4, 6);
        }
        return aSet.contains(a) && bSet.contains(b);
    }
}
