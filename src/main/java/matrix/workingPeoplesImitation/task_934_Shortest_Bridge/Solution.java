package matrix.workingPeoplesImitation.task_934_Shortest_Bridge;

import java.util.*;

public class Solution {

    // my solution
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean diff = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!diff) {
                        changeLandscape(grid, i, j);
                        diff = true;
                    } else {
                        return findMinBridge(grid, i, j);
                    }
                }
            }
        }
        return -1;
    }
    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void changeLandscape(int[][] grid, int i, int j) {
        grid[i][j] = 2;
        for (int[] dir : dirs) {
            int a = i + dir[0];
            int b = j + dir[1];
            if (a < 0 || b < 0 || a >= grid.length || b >= grid.length || grid[a][b] != 1) {
                continue;
            }
            changeLandscape(grid, a, b);
        }
    }
    private int findMinBridge(int[][] grid, int i, int j) {
        int level = 1;
        Map<Integer, Set<Integer>> border = findBorder(grid, i, j);
        w: while (!border.isEmpty()) {
            Map<Integer, Set<Integer>> newBorder = new HashMap<>();
            for (int y : border.keySet()) {
                for (int x : border.get(y)) {
                    for (int[] dir : dirs) {
                        int a = y + dir[0];
                        int b = x + dir[1];
                        if (a < 0 || b < 0 || a >= grid.length || b >= grid.length) {
                            continue;
                        }
                        if (grid[a][b] == 2) {
                            break w;
                        }
                        if (grid[a][b] == 0) {
                            grid[a][b] = 1;
                            newBorder.computeIfAbsent(a, set -> new HashSet<>()).add(b);
                        }
                    }
                }
            }
            level++;
            border = newBorder;
        }
        return level;
    }
    private Map<Integer, Set<Integer>> findBorder(int[][] grid, int i, int j) {
        Map<Integer, Set<Integer>> island = new HashMap<>();
        Map<Integer, Set<Integer>> border = new HashMap<>();
        findIsland(grid, i, j, island);
        island.computeIfAbsent(i, set -> new HashSet<>()).add(j);
        for (int y : island.keySet()) {
            for (int x : island.get(y)) {
                for (int[] dir : dirs) {
                    int a = y + dir[0];
                    int b = x + dir[1];
                    if (a < 0 || b < 0 || a >= grid.length || b >= grid.length) {
                        continue;
                    }
                    if (grid[a][b] == 0) {
                        border.computeIfAbsent(a, set -> new HashSet<>()).add(b);
                    }
                }
            }
        }
        return border;
    }
    private void findIsland(int[][] grid, int i, int j, Map<Integer, Set<Integer>> border) {
        for (int[] dir : dirs) {
            int a = i + dir[0];
            int b = j + dir[1];
            if (a < 0 || b < 0 || a >= grid.length || b >= grid.length) {
                continue;
            }
            if (grid[a][b] == 1 && (!border.containsKey(a) || !border.get(a).contains(b))) {
                border.computeIfAbsent(a, set -> new HashSet<>()).add(b);
                findIsland(grid, a, b, border);
            }
        }
    }
}
