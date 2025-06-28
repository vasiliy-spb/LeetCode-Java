package matrix.workingPeoplesImitation.task_1034_Coloring_A_Border;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// my solution
public class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int startColor = grid[row][col];
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            visited.put(i, new HashSet<>());
        }
        paintBorder(grid, row, col, startColor, color, visited);
        return grid;
    }

    private void paintBorder(int[][] grid, int row, int col, int startColor, int color, Map<Integer, Set<Integer>> visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) {
            return;
        }
        if (grid[row][col] != startColor) {
            return;
        }
        if (visited.get(row).contains(col)) {
            return;
        }
        visited.get(row).add(col);
        if (getNeighboursCount(grid, row, col, startColor, color, visited) < 4) {
            grid[row][col] = color;
        }
        paintBorder(grid, row + 1, col, startColor, color, visited);
        paintBorder(grid, row, col + 1, startColor, color, visited);
        paintBorder(grid, row - 1, col, startColor, color, visited);
        paintBorder(grid, row, col - 1, startColor, color, visited);
    }

    private int getNeighboursCount(int[][] grid, int row, int col, int startColor, int color, Map<Integer, Set<Integer>> visited) {
        int count = 0;
        if (row - 1 >= 0) {
            if (grid[row - 1][col] == color && visited.get(row - 1).contains(col) || grid[row - 1][col] == startColor) {
                count++;
            }
        }
        if (row + 1 < grid.length) {
            if (grid[row + 1][col] == color && visited.get(row + 1).contains(col) || grid[row + 1][col] == startColor) {
                count++;
            }
        }
        if (col - 1 >= 0) {
            if (grid[row][col - 1] == color && visited.get(row).contains(col - 1) || grid[row][col - 1] == startColor) {
                count++;
            }
        }
        if (col + 1 < grid[row].length) {
            if (grid[row][col + 1] == color && visited.get(row).contains(col + 1) || grid[row][col + 1] == startColor) {
                count++;
            }
        }
        return count;
    }
}
