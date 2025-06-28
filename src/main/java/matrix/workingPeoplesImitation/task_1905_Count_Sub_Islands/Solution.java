package matrix.workingPeoplesImitation.task_1905_Count_Sub_Islands;

import java.util.*;

public class Solution {

    // my solution
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int count = 0;
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && (!visited.containsKey(i) || visited.containsKey(i) && !visited.get(i).contains(j))) {
                    boolean subIsland = isSubIsland(grid1, grid2, i, j, visited);
                    if (subIsland) {
                        count++;
                        coverSubIsland(grid2, i, j);
                    }
                }
            }
        }
        return count;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j, Map<Integer, Set<Integer>> visited) {
        boolean ans = true;
        if (grid2[i][j] != grid1[i][j]) {
            return false;
        }
        visited.computeIfAbsent(i, set -> new HashSet<>()).add(j);
        if (i - 1 >= 0 && grid2[i - 1][j] == 1
                && (!visited.containsKey(i - 1) || visited.containsKey(i - 1) && !visited.get(i - 1).contains(j))
        ) {
            ans &= isSubIsland(grid1, grid2, i - 1, j, visited);
        }
        if (i + 1 < grid2.length && grid2[i + 1][j] == 1
                && (!visited.containsKey(i + 1) || visited.containsKey(i + 1) && !visited.get(i + 1).contains(j))
        ) {
            ans &= isSubIsland(grid1, grid2, i + 1, j, visited);
        }
        if (j - 1 >= 0 && grid2[i][j - 1] == 1
                && (!visited.containsKey(i) || visited.containsKey(i) && !visited.get(i).contains(j - 1))
        ) {
            ans &= isSubIsland(grid1, grid2, i, j - 1, visited);
        }
        if (j + 1 < grid2[0].length && grid2[i][j + 1] == 1
                && (!visited.containsKey(i) || visited.containsKey(i) && !visited.get(i).contains(j + 1))
        ) {
            ans &= isSubIsland(grid1, grid2, i, j + 1, visited);
        }
        return ans;
    }

    private void coverSubIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        coverSubIsland(grid, i - 1, j);
        coverSubIsland(grid, i + 1, j);
        coverSubIsland(grid, i, j - 1);
        coverSubIsland(grid, i, j + 1);
    }

    // from leetcode editorial (Approach 1: Breadth-First Search)
    // Directions in which we can traverse inside the grids.
    private final int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
    };

    // Helper method to check if the cell at the position (x, y) in the 'grid'
    // is a land cell.
    private boolean isCellLand(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }

    // Traverse all cells of island starting at position (x, y) in 'grid2',
    // and check this island is a sub-island in 'grid1'.
    private boolean isSubIsland(
            int x,
            int y,
            int[][] grid1,
            int[][] grid2,
            boolean[][] visited
    ) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;

        boolean isSubIsland = true;

        Queue<int[]> pendingCells = new LinkedList<>();
        // Push the starting cell in the queue and mark it as visited.
        pendingCells.offer(new int[] { x, y });
        visited[x][y] = true;

        // Traverse on all cells using the breadth-first search method.
        while (!pendingCells.isEmpty()) {
            int[] curr = pendingCells.poll();
            int currX = curr[0];
            int currY = curr[1];

            // If the current position cell is not a land cell in 'grid1',
            // then the current island can't be a sub-island.
            if (!isCellLand(currX, currY, grid1)) {
                isSubIsland = false;
            }

            for (int[] direction : directions) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];
                // If the next cell is inside 'grid2', is never visited and
                // is a land cell, then we traverse to the next cell.
                if (
                        nextX >= 0 &&
                                nextY >= 0 &&
                                nextX < totalRows &&
                                nextY < totalCols &&
                                !visited[nextX][nextY] &&
                                isCellLand(nextX, nextY, grid2)
                ) {
                    // Push the next cell in the queue and mark it as visited.
                    pendingCells.offer(new int[] { nextX, nextY });
                    visited[nextX][nextY] = true;
                }
            }
        }

        return isSubIsland;
    }

    public int countSubIslands2(int[][] grid1, int[][] grid2) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;

        boolean[][] visited = new boolean[totalRows][totalCols];
        int subIslandCounts = 0;

        // Iterate on each cell in 'grid2'
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                // If cell at the position (x, y) in the 'grid2' is not visited,
                // is a land cell in 'grid2', and the island
                // starting from this cell is a sub-island in 'grid1', then we
                // increment the count of sub-islands.
                if (
                        !visited[x][y] &&
                                isCellLand(x, y, grid2) &&
                                isSubIsland(x, y, grid1, grid2, visited)
                ) {
                    subIslandCounts += 1;
                }
            }
        }
        // Return total count of sub-islands.
        return subIslandCounts;
    }

    // from leetcode editorial (Approach 2: Depth-First Search)
    // Directions in which we can traverse inside the grids.
    private final int[][] directions2 = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
    };

    // Helper method to check if the cell at the position (x, y) in the 'grid'
    // is a land cell.
    private boolean isCellLand2(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }

    // Traverse all cells of island starting at position (x, y) in 'grid2',
    // and check if this island is a sub-island in 'grid1'.
    private boolean isSubIsland2(
            int x,
            int y,
            int[][] grid1,
            int[][] grid2,
            boolean[][] visited
    ) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;
        // Traverse on all cells using the depth-first search method.
        boolean isSubIsland = true;

        // If the current cell is not a land cell in 'grid1', then the current island can't be a sub-island.
        if (!isCellLand2(x, y, grid1)) {
            isSubIsland = false;
        }

        // Traverse on all adjacent cells.
        for (int[] direction : directions2) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            // If the next cell is inside 'grid2', is not visited, and is a land cell,
            // then we traverse to the next cell.
            if (
                    nextX >= 0 &&
                            nextY >= 0 &&
                            nextX < totalRows &&
                            nextY < totalCols &&
                            !visited[nextX][nextY] &&
                            isCellLand(nextX, nextY, grid2)
            ) {
                // Mark the next cell as visited.
                visited[nextX][nextY] = true;
                boolean nextCellIsPartOfSubIsland = isSubIsland2(
                        nextX,
                        nextY,
                        grid1,
                        grid2,
                        visited
                );
                isSubIsland = isSubIsland && nextCellIsPartOfSubIsland;
            }
        }
        return isSubIsland;
    }

    public int countSubIslands3(int[][] grid1, int[][] grid2) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;

        boolean[][] visited = new boolean[totalRows][totalCols];
        int subIslandCounts = 0;

        // Iterate over each cell in 'grid2'.
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                // If the cell at position (x, y) in 'grid2' is not visited,
                // is a land cell in 'grid2', and the island starting from this cell is a sub-island in 'grid1',
                // then increment the count of sub-islands.
                if (!visited[x][y] && isCellLand(x, y, grid2)) {
                    visited[x][y] = true;
                    if (isSubIsland(x, y, grid1, grid2, visited)) {
                        subIslandCounts += 1;
                    }
                }
            }
        }
        // Return total count of sub-islands.
        return subIslandCounts;
    }

    // from leetcode editorial (Approach 3: Union-Find)
    // Directions in which we can traverse inside the grids.
    private final int[][] directions3 = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
    };

    // Helper method to check if the cell at the position (x, y) in the 'grid'
    // is a land cell.
    private boolean isCellLand3(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }

    // Union-Find class.
    class UnionFind {

        private final int[] parent;
        private final int[] rank;

        // Initialize union-find object with 'n' elements.
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Find the root of element 'u', using the path-compression technique.
        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        // Union two components of elements 'u' and 'v' respectively based on
        // their ranks.
        void unionSets(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }

    // Helper method to convert (x, y) position to a 1-dimensional index.
    private int convertToIndex(int x, int y, int totalCols) {
        return x * totalCols + y;
    }

    public int countSubIslands4(int[][] grid1, int[][] grid2) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;
        UnionFind uf = new UnionFind(totalRows * totalCols);

        // Traverse each land cell of 'grid2'.
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                if (isCellLand(x, y, grid2)) {
                    // Union adjacent land cells with the current land cell.
                    for (int[] direction : directions3) {
                        int nextX = x + direction[0];
                        int nextY = y + direction[1];
                        if (
                                nextX >= 0 &&
                                        nextY >= 0 &&
                                        nextX < totalRows &&
                                        nextY < totalCols &&
                                        isCellLand3(nextX, nextY, grid2)
                        ) {
                            uf.unionSets(
                                    convertToIndex(x, y, totalCols),
                                    convertToIndex(nextX, nextY, totalCols)
                            );
                        }
                    }
                }
            }
        }

        // Traverse 'grid2' land cells and mark that cell's root as not a sub-island
        // if the land cell is not present at the respective position in 'grid1'.
        boolean[] isSubIsland = new boolean[totalRows * totalCols];
        for (int i = 0; i < isSubIsland.length; i++) {
            isSubIsland[i] = true;
        }
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                if (isCellLand(x, y, grid2) && !isCellLand(x, y, grid1)) {
                    int root = uf.find(convertToIndex(x, y, totalCols));
                    isSubIsland[root] = false;
                }
            }
        }

        // Count all the sub-islands.
        int subIslandCounts = 0;
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                if (isCellLand(x, y, grid2)) {
                    int root = uf.find(convertToIndex(x, y, totalCols));
                    if (isSubIsland[root]) {
                        subIslandCounts++;
                        // One cell can be the root of multiple land cells, so to
                        // avoid counting the same island multiple times, mark it as false.
                        isSubIsland[root] = false;
                    }
                }
            }
        }

        return subIslandCounts;
    }

    // from walkccc.me
    public int countSubIslands5(int[][] grid1, int[][] grid2) {
        int ans = 0;

        for (int i = 0; i < grid2.length; ++i)
            for (int j = 0; j < grid2[0].length; ++j)
                if (grid2[i][j] == 1)
                    ans += dfs(grid1, grid2, i, j);

        return ans;
    }

    private int dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i == grid1.length || j < 0 || j == grid2[0].length)
            return 1;
        if (grid2[i][j] != 1)
            return 1;

        grid2[i][j] = 2; // Mark 2 as visited.

        return                                                          //
                dfs(grid1, grid2, i + 1, j) & dfs(grid1, grid2, i - 1, j) & //
                        dfs(grid1, grid2, i, j + 1) & dfs(grid1, grid2, i, j - 1) & grid1[i][j];
    }

}
