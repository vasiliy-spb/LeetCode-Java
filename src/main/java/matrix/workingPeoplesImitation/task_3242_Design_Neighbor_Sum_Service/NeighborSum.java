package matrix.workingPeoplesImitation.task_3242_Design_Neighbor_Sum_Service;

import java.util.HashMap;
import java.util.Map;

public class NeighborSum {
    private static final int[][] ADJACENT_DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[][] DIAGONAL_DIRECTIONS = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};

    private Map<Integer, Integer> hashes;
    private int[][] grid;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.hashes = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                hashes.put(grid[i][j], i * n + j);
            }
        }
    }

    public int adjacentSum(int value) {
        return calculateSum(value, ADJACENT_DIRECTIONS);
    }

    public int diagonalSum(int value) {
        return calculateSum(value, DIAGONAL_DIRECTIONS);
    }

    private int calculateSum(int value, int[][] directions) {
        int hash = hashes.get(value);
        int row = hash / grid.length;
        int column = hash % grid.length;

        int sum = 0;
        for (int[] direction : directions) {
            int i = row + direction[0];
            int j = column + direction[1];
            if (!isExists(i, j)) {
                continue;
            }
            sum += grid[i][j];
        }
        return sum;
    }

    private boolean isExists(int i, int j) {
        int n = grid.length;
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}