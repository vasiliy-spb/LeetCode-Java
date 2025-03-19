package matrix.workingPeoplesImitation.task_1559_Detect_Cycles_in_2D_Grid;

// my solution
public class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean containsCycle(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] >= 'a' && grid[i][j] <= 'z') {
                    if (traverse(grid, i, j, grid[i][j], -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int getKey(int i, int j, int length) {
        return i * length + j;
    }

    private boolean traverse(char[][] grid, int i, int j, char letter, int prevKey) {
        int key = getKey(i, j, grid[0].length);
        grid[i][j] = (char) (letter + 'z');
        for (int[] direction : DIRECTIONS) {
            int y = i + direction[0];
            int x = j + direction[1];
            if (!isValid(y, x, grid)) {
                continue;
            }
            int nextKey = getKey(y, x, grid[0].length);
            if (grid[y][x] == letter + 'z' && nextKey != prevKey) {
                return true;
            }
            if (grid[y][x] == letter) {
                if (traverse(grid, y, x, letter, key)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int y, int x, char[][] grid) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
