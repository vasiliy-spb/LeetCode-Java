package matrix.workingPeoplesImitation.task_200_Number_of_Islands;

import java.util.*;

public class Solution {

    // my solution
    public int numIslands(char[][] grid) {
        int count = 0;
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited.getOrDefault(i, new HashSet<>()).contains(j)) {
                    count++;
                    goAroundTheIsland(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    private void goAroundTheIsland(char[][] grid, int i, int j, Map<Integer, Set<Integer>> visited) {
        visited.computeIfAbsent(i, set -> new HashSet<>()).add(j);
        if (i > 0 && grid[i - 1][j] == '1' && !visited.getOrDefault(i - 1, new HashSet<>()).contains(j))
            goAroundTheIsland(grid, i - 1, j, visited);
        if (j > 0 && grid[i][j - 1] == '1' && !visited.getOrDefault(i, new HashSet<>()).contains(j - 1))
            goAroundTheIsland(grid, i, j - 1, visited);
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !visited.getOrDefault(i + 1, new HashSet<>()).contains(j))
            goAroundTheIsland(grid, i + 1, j, visited);
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1' && !visited.getOrDefault(i, new HashSet<>()).contains(j + 1))
            goAroundTheIsland(grid, i, j + 1, visited);
    }

    // from walkccc.me (Approach 1: BFS)
    public int numIslands2(char[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ++ans;
                }

        return ans;
    }

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        grid[r][c] = '2'; // Mark '2' as visited.
        while (!q.isEmpty()) {
            final int i = q.peek()[0];
            final int j = q.poll()[1];
            for (int[] dir : dirs) {
                final int x = i + dir[0];
                final int y = j + dir[1];
                if (x < 0 || x == grid.length || y < 0 || y == grid[0].length)
                    continue;
                if (grid[x][y] != '1')
                    continue;
                q.offer(new int[] {x, y});
                grid[x][y] = '2'; // Mark '2' as visited.
            }
        }
    }

    // from walkccc.me (Approach 2: DFS)
    public int numIslands3(char[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++ans;
                }

        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;
        if (grid[i][j] != '1')
            return;

        grid[i][j] = '2'; // Mark '2' as visited.
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
