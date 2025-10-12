package matrix.workingPeoplesImitation.task_3242_Design_Neighbor_Sum_Service;

// from leetcode code sample (1)
public class NeighborSum3 {
    int[][] grid;
    int len;
    int[] adjacent, diagonal;

    public NeighborSum3(int[][] grid) {
        this.grid = grid;
        len = grid.length;
        int size = len * len;
        adjacent = new int[size];
        diagonal = new int[size];
    }

    public int adjacentSum(int value) {
        if (adjacent[value] > 0) return adjacent[value];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                int sum = 0;
                if (i > 0) sum += grid[i - 1][j];
                if (j > 0) sum += grid[i][j - 1];
                if (i < len - 1) sum += grid[i + 1][j];
                if (j < len - 1) sum += grid[i][j + 1];
                adjacent[grid[i][j]] = sum;
            }
        }
        return adjacent[value];
    }

    public int diagonalSum(int value) {
        if (diagonal[value] > 0) return diagonal[value];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                int sum = 0;
                if (i > 0 && j > 0) sum += grid[i - 1][j - 1];
                if (i > 0 && j < len - 1) sum += grid[i - 1][j + 1];
                if (i < len - 1 && j > 0) sum += grid[i + 1][j - 1];
                if (i < len - 1 && j < len - 1) sum += grid[i + 1][j + 1];
                diagonal[grid[i][j]] = sum;
            }
        }
        return diagonal[value];
    }
}
