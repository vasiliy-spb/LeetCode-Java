package matrix.workingPeoplesImitation.task_463_Island_Perimeter;

public class Solution {

    // my solution
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int neighbors = calculateNeighbors(grid, i, j);
                    perimeter += 4 - neighbors;
                }
            }
        }
        return perimeter;
    }
    public int calculateNeighbors(int[][] grid, int i, int j) {
        int count = 0;
        if (i > 0 && grid[i - 1][j] == 1) count++;
        if (j > 0 && grid[i][j - 1] == 1) count++;
        if (i < grid.length - 1 && grid[i + 1][j] == 1) count++;
        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) count++;
        return count;
    }

    // from walkccc.me
    public int islandPerimeter2(int[][] grid) {
        int islands = 0;
        int neighbors = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 1) {
                    ++islands;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                        ++neighbors;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                        ++neighbors;
                }

        return islands * 4 - neighbors * 2;
    }
}
