package matrix.workingPeoplesImitation.task_1914_Cyclically_Rotating_a_Grid;

import java.util.ArrayList;
import java.util.List;

import static matrix.workingPeoplesImitation.utils.MatrixUtils.printMatrix;

public class Solution {

    // my solution (Approach 1)
    public int[][] rotateGrid(int[][] grid, int k) {
        int n = Math.min(grid.length, grid[0].length);
        for (int i = 0; i < n / 2; i++) {
            int count = k % ((Math.abs(i - (grid.length - 1 - i)) + Math.abs(i - (grid[0].length - 1 - i))) * 2);
            for (int j = 0; j < count; j++) {
                rotateLayerByOne(grid, i, grid.length - 1 - i, i, grid[0].length - 1 - i);
            }
        }
        return grid;
    }

    private void rotateLayerByOne(int[][] grid, int top, int bottom, int left, int right) {
        int topLeft = grid[top][left];
        for (int i = left; i < right; i++) {
            grid[top][i] = grid[top][i + 1];
        }
        for (int i = top; i < bottom; i++) {
            grid[i][right] = grid[i + 1][right];
        }
        for (int i = right; i > left; i--) {
            grid[bottom][i] = grid[bottom][i - 1];
        }
        for (int i = bottom; i > top; i--) {
            grid[i][left] = grid[i - 1][left];
        }
        grid[top + 1][left] = topLeft;
    }

    // my solution (Approach 2)
    public int[][] rotateGrid2(int[][] grid, int k) {
        int n = Math.min(grid.length, grid[0].length);
        for (int i = 0; i < n / 2; i++) {
            rotateLayerByK(grid, i, grid.length - 1 - i, i, grid[0].length - 1 - i, k);
        }
        return grid;
    }

    private void rotateLayerByK(int[][] grid, int top, int bottom, int left, int right, int k) {
        List<Integer> layer = new ArrayList<>();
        for (int i = left; i < right; i++) {
            layer.add(grid[top][i]);
        }
        for (int i = top; i < bottom; i++) {
            layer.add(grid[i][right]);
        }
        for (int i = right; i > left; i--) {
            layer.add(grid[bottom][i]);
        }
        for (int i = bottom; i > top; i--) {
            layer.add(grid[i][left]);
        }
        int index = k % layer.size();
        for (int i = left; i < right; i++) {
            grid[top][i] = layer.get(index++);
            index %= layer.size();
        }
        for (int i = top; i < bottom; i++) {
            grid[i][right] = layer.get(index++);
            index %= layer.size();
        }
        for (int i = right; i > left; i--) {
            grid[bottom][i] = layer.get(index++);
            index %= layer.size();
        }
        for (int i = bottom; i > top; i--) {
            grid[i][left] = layer.get(index++);
            index %= layer.size();
        }
    }
}