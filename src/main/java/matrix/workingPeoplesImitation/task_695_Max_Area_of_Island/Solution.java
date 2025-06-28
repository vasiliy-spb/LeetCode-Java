package matrix.workingPeoplesImitation.task_695_Max_Area_of_Island;

import java.util.Stack;

public class Solution {

    // my solution
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int currentArea = calculateArea(grid, i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    private int calculateArea(int[][] grid, int i, int j) {
        if (grid[i][j] != 1) {
            return 0;
        }
        int count = 1;
        grid[i][j] = 2;
        if (i - 1 >= 0) {
            count += calculateArea(grid, i - 1, j);
        }
        if (j - 1 >= 0) {
            count += calculateArea(grid, i, j - 1);
        }
        if (i + 1 < grid.length) {
            count += calculateArea(grid, i + 1, j);
        }
        if (j + 1 < grid[i].length) {
            count += calculateArea(grid, i, j + 1);
        }
        return count;
    }

    // from leetcode editorial(Approach #1: Depth-First Search (Recursive) [Accepted])
    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                + area(r, c-1) + area(r, c+1));
    }

    public int maxAreaOfIsland2(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }

    // from leetcode editorial(Approach #2: Depth-First Search (Iterative) [Accepted])
    public int maxAreaOfIsland3(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int ans = 0;
        for (int r0 = 0; r0 < grid.length; r0++) {
            for (int c0 = 0; c0 < grid[0].length; c0++) {
                if (grid[r0][c0] == 1 && !seen[r0][c0]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[]{r0, c0});
                    seen[r0][c0] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int r = node[0], c = node[1];
                        shape++;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < grid.length &&
                                    0 <= nc && nc < grid[0].length &&
                                    grid[nr][nc] == 1 && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }

    // from walkccc.me
    public int maxAreaOfIsland4(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                ans = Math.max(ans, dfs(grid, i, j));

        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return 0;
        if (grid[i][j] != 1)
            return 0;

        grid[i][j] = 2;

        return 1 +                                      //
                dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + //
                dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }

}


/*

1 1
1 1 1
1 1 1 1 1 1
1 1 1 1 1 1


 */