package matrix.workingPeoplesImitation.task_2556_Disconnect_Path_in_a_Binary_Matrix_by_at_Most_One_Flip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// my solution
public class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        if (isValidCondition(grid)) {
            return true;
        }
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || (i == n - 1 && j == m - 1)) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    int maxNeighbourCount = getMaxNeighboursCount(grid, i, j);
                    int neighbourCount = getNeighboursCount(grid, i, j);
                    if (maxNeighbourCount == 2 || neighbourCount > 1 && neighbourCount < maxNeighbourCount) {
                        grid[i][j] = 2;
                        if (isValidCondition(grid)) {
                            return true;
                        }
                        grid[i][j] = 1;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidCondition(int[][] grid) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int a = 0; a < grid.length; a++) {
            map.put(a, new HashSet<>());
        }
        int i = 0;
        int j = 0;
        map.get(i).add(j);
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            dfs(grid, i + 1, j, map);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
            dfs(grid, i, j + 1, map);
        }
        return !map.get(grid.length - 1).contains(grid[i].length - 1);
    }

    private int getMaxNeighboursCount(int[][] grid, int i, int j) {
        int count = 0;
        if (i - 1 >= 0) {
            count++;
        }
        if (i + 1 < grid.length) {
            count++;
        }
        if (j - 1 >= 0) {
            count++;
        }
        if (j + 1 < grid[i].length) {
            count++;
        }
        if (i - 1 >= 0 && j - 1 >= 0) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < grid[i].length) {
            count++;
        }
        if (i + 1 < grid.length && j - 1 >= 0) {
            count++;
        }
        if (i + 1 < grid.length && j + 1 < grid[i].length) {
            count++;
        }
        return count;
    }

    private int getNeighboursCount(int[][] grid, int i, int j) {
        int count = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            count++;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            count++;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            count++;
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
            count++;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 1) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < grid[i].length && grid[i - 1][j + 1] == 1) {
            count++;
        }
        if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 1) {
            count++;
        }
        if (i + 1 < grid.length && j + 1 < grid[i].length && grid[i + 1][j + 1] == 1) {
            count++;
        }
        return count;
    }
    private void dfs(int[][] grid, int i, int j, Map<Integer, Set<Integer>> map) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == 1) {
            if (!map.get(i).contains(j)) {
                map.get(i).add(j);
                dfs(grid, i + 1, j, map);
                dfs(grid, i, j + 1, map);
            }
        }
    }
}
