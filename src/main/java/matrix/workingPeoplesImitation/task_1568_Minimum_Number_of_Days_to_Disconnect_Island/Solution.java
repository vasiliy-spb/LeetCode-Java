package matrix.workingPeoplesImitation.task_1568_Minimum_Number_of_Days_to_Disconnect_Island;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // my solution
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if ((n == 2 && m == 1 || n == 1 && m == 2) && grid[0][0] == 1) {
            return 2;
        }
        int[][] neighbours = new int[n][m];
        Set<Integer>[] visited = new HashSet[n];
        for (int i = 0; i < n; i++) {
            visited[i] = new HashSet<>();
        }
        boolean hasIsland = false;
        boolean hasBridge = false;
        int countLand = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    countLand++;
                    if (!visited[i].contains(j)) {
                        dfs(grid, i, j, visited);
                        if (hasIsland) {
                            return 0;
                        }
                        hasIsland = true;
                    }
                    neighbours[i][j] = calculateCountNeighbours(grid, i, j);
                    if (neighbours[i][j] >= 2) {
                        if (!hasBridge && isBridge(grid, i, j)) {
                            hasBridge = true;
                        }
                    }
                }
            }
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (neighbours[i][j] > 0) {
                    count = Math.min(count, neighbours[i][j]);
                }
            }
        }
        if (hasBridge || countLand == 1) {
            return 1;
        }
        if (countLand == 2) {
            return 2;
        }
        if (countLand == 0) {
            return 0;
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    private boolean isBridge(int[][] grid, int i, int j) {
        Set<Integer>[] visited = new HashSet[grid.length];
        for (int v = 0; v < grid.length; v++) {
            visited[v] = new HashSet<>();
        }

        if (isHorizontalBridge(grid, i, j)) {
            visited[i].add(j);
            dfsWithBridge(grid, i, j + 1, visited, i, j);
//                printMatrix(visited, grid.length, grid[0].length);
//                System.out.println("visited[i - 1].contains(j) == " + visited[i - 1].contains(j));
            return !visited[i].contains(j - 1);
        } else if (isVerticalBridge(grid, i, j)) {
            visited[i].add(j);
            dfsWithBridge(grid, i + 1, j, visited, i, j);
//                printMatrix(visited, grid.length, grid[0].length);
//                System.out.println("visited[i].contains(j - 1) == " + visited[i].contains(j - 1));
            return !visited[i - 1].contains(j);
        }
        return false;
    }

    private boolean isVerticalBridge(int[][] grid, int i, int j) {
        return i - 1 >= 0 && grid[i - 1][j] == 1 && i + 1 < grid.length && grid[i + 1][j] == 1;
    }

    private boolean isHorizontalBridge(int[][] grid, int i, int j) {
        return j - 1 >= 0 && grid[i][j - 1] == 1 && j + 1 < grid[i].length && grid[i][j + 1] == 1;
    }

    private void printMatrix(Set<Integer>[] visited, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i].contains(j)) {
                    System.out.print(" +");
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
    }


    private void dfsWithBridge(int[][] grid, int i, int j, Set<Integer>[] visited, int bridgeI, int bridgeJ) {
        if (i == bridgeI && j == bridgeJ && visited[i].contains(j)) {
            return;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        if (visited[i].contains(j)) {
            return;
        }
        visited[i].add(j);
        dfsWithBridge(grid, i + 1, j, visited, bridgeI, bridgeJ);
        dfsWithBridge(grid, i, j + 1, visited, bridgeI, bridgeJ);
        dfsWithBridge(grid, i - 1, j, visited, bridgeI, bridgeJ);
        dfsWithBridge(grid, i, j - 1, visited, bridgeI, bridgeJ);
    }

    private void dfs(int[][] grid, int i, int j, Set<Integer>[] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        if (visited[i].contains(j)) {
            return;
        }
        visited[i].add(j);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
    }

    private int calculateCountNeighbours(int[][] grid, int i, int j) {
        int count = 0;
        if (i - 1 >= 0) {
            count += grid[i - 1][j];
        }
        if (i + 1 < grid.length) {
            count += grid[i + 1][j];
        }
        if (j - 1 >= 0) {
            count += grid[i][j - 1];
        }
        if (j + 1 < grid[i].length) {
            count += grid[i][j + 1];
        }
        return count;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // from leetcode editorial (Approach 1: Brute Force)
    // Directions for adjacent cells: right, left, down, up
    private static final int[][] DIRECTIONS = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
    };

    public int minDays2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Count initial islands
        int initialIslandCount = countIslands(grid);

        // Already disconnected or no land
        if (initialIslandCount != 1) {
            return 0;
        }

        // Try removing each land cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue; // Skip water

                // Temporarily change to water
                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);

                // Check if disconnected
                if (newIslandCount != 1) return 1;

                // Revert change
                grid[row][col] = 1;
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        // Iterate through all cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Found new island
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // Helper method to explore all cells of an island
    private void exploreIsland(
            int[][] grid,
            int row,
            int col,
            boolean[][] visited
    ) {
        visited[row][col] = true;

        // Check all adjacent cells
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // Explore if valid land cell
            if (isValidLandCell(grid, newRow, newCol, visited)) {
                exploreIsland(grid, newRow, newCol, visited);
            }
        }
    }

    private boolean isValidLandCell(
            int[][] grid,
            int row,
            int col,
            boolean[][] visited
    ) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check bounds, land, and not visited
        return (
                row >= 0 &&
                        col >= 0 &&
                        row < rows &&
                        col < cols &&
                        grid[row][col] == 1 &&
                        !visited[row][col]
        );
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // from leetcode editorial (Approach 2: Tarjan's Algorithm)
    // Directions for adjacent cells: right, down, left, up
    private static final int[][] DIRECTIONS_2 = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
    };

    public int minDays3(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        ArticulationPointInfo apInfo = new ArticulationPointInfo(false, 0);
        int landCells = 0, islandCount = 0;

        // Arrays to store information for each cell
        int[][] discoveryTime = new int[rows][cols]; // Time when a cell is first discovered
        int[][] lowestReachable = new int[rows][cols]; // Lowest discovery time reachable from the subtree rooted at
        // this cell
        int[][] parentCell = new int[rows][cols]; // Parent of each cell in DFS tree

        // Initialize arrays with default values
        for (int i = 0; i < rows; i++) {
            Arrays.fill(discoveryTime[i], -1);
            Arrays.fill(lowestReachable[i], -1);
            Arrays.fill(parentCell[i], -1);
        }

        // Traverse the grid to find islands and articulation points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    landCells++;
                    if (discoveryTime[i][j] == -1) { // If not yet visited
                        // Start DFS for a new island
                        findArticulationPoints(
                                grid,
                                i,
                                j,
                                discoveryTime,
                                lowestReachable,
                                parentCell,
                                apInfo
                        );
                        islandCount++;
                    }
                }
            }
        }

        // Determine the minimum number of days to disconnect the grid
        if (islandCount == 0 || islandCount >= 2) return 0; // Already disconnected or no land
        if (landCells == 1) return 1; // Only one land cell
        if (apInfo.hasArticulationPoint) return 1; // An articulation point exists
        return 2; // Need to remove any two land cells
    }

    private void findArticulationPoints(
            int[][] grid,
            int row,
            int col,
            int[][] discoveryTime,
            int[][] lowestReachable,
            int[][] parentCell,
            ArticulationPointInfo apInfo
    ) {
        int rows = grid.length, cols = grid[0].length;
        discoveryTime[row][col] = apInfo.time;
        apInfo.time++;
        lowestReachable[row][col] = discoveryTime[row][col];
        int children = 0;

        // Explore all adjacent cells
        for (int[] direction : DIRECTIONS_2) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidLandCell(grid, newRow, newCol)) {
                if (discoveryTime[newRow][newCol] == -1) {
                    children++;
                    parentCell[newRow][newCol] = row * cols + col; // Set parent
                    findArticulationPoints(
                            grid,
                            newRow,
                            newCol,
                            discoveryTime,
                            lowestReachable,
                            parentCell,
                            apInfo
                    );

                    // Update lowest reachable time
                    lowestReachable[row][col] = Math.min(
                            lowestReachable[row][col],
                            lowestReachable[newRow][newCol]
                    );

                    // Check for articulation point condition
                    if (
                            lowestReachable[newRow][newCol] >=
                                    discoveryTime[row][col] &&
                                    parentCell[row][col] != -1
                    ) {
                        apInfo.hasArticulationPoint = true;
                    }
                } else if (newRow * cols + newCol != parentCell[row][col]) {
                    // Update lowest reachable time for back edge
                    lowestReachable[row][col] = Math.min(
                            lowestReachable[row][col],
                            discoveryTime[newRow][newCol]
                    );
                }
            }
        }

        // Root of DFS tree is an articulation point if it has more than one child
        if (parentCell[row][col] == -1 && children > 1) {
            apInfo.hasArticulationPoint = true;
        }
    }

    // Check if the given cell is a valid land cell
    private boolean isValidLandCell(int[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        return (
                row >= 0 &&
                        col >= 0 &&
                        row < rows &&
                        col < cols &&
                        grid[row][col] == 1
        );
    }

    private class ArticulationPointInfo {

        boolean hasArticulationPoint;
        int time;

        ArticulationPointInfo(boolean hasArticulationPoint, int time) {
            this.hasArticulationPoint = hasArticulationPoint;
            this.time = time;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // from walkccc.me
    public int minDays4(int[][] grid) {
        if (disconnected(grid))
            return 0;

        // Try to remove 1 land.
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (disconnected(grid))
                        return 1;
                    grid[i][j] = 1;
                }

        // Remove 2 lands.
        return 2;
    }

    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean disconnected(int[][] grid) {
        int islandsCount = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0 || seen[i][j])
                    continue;
                if (++islandsCount > 1)
                    return true;
                dfs2(grid, i, j, seen);
            }

        return islandsCount != 1;
    }

    private void dfs2(int[][] grid, int i, int j, boolean[][] seen) {
        seen[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x == grid.length || y < 0 || y == grid[0].length)
                continue;
            if (grid[x][y] == 0 || seen[x][y])
                continue;
            dfs2(grid, x, y, seen);
        }
    }

}
