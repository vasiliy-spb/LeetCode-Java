package matrix.workingPeoplesImitation.task_1254_Number_of_Closed_Islands;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        Set<Integer> notAnIsland = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int marker = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && !visited.contains(getKey(i, j, grid[i].length))) {
                    traverse(grid, i, j, marker, visited, notAnIsland);
                    marker++;
                }
            }
        }
        return marker - 2 - notAnIsland.size();
    }

    private Integer getKey(int i, int j, int length) {
        return i * length + j;
    }

    private void traverse(int[][] grid, int i, int j, int marker, Set<Integer> visited, Set<Integer> notAnIsland) {
        if (grid[i][j] != 0) {
            return;
        }
        grid[i][j] = marker;
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            notAnIsland.add(marker);
        }
        visited.add(getKey(i, j, grid[0].length));
        for (int[] direction : DIRECTIONS) {
            int y = i + direction[0];
            int x = j + direction[1];
            if (isValid(y, x, grid)) {
                traverse(grid, y, x, marker, visited, notAnIsland);
            }
        }
    }

    private boolean isValid(int y, int x, int[][] grid) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
