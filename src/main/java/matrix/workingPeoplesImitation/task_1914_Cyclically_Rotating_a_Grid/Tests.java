package matrix.workingPeoplesImitation.task_1914_Cyclically_Rotating_a_Grid;

import org.junit.Test;

import static matrix.workingPeoplesImitation.utils.MatrixUtils.areMatrixEquals;
import static matrix.workingPeoplesImitation.utils.MatrixUtils.printMatrix;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {{40, 10}, {30, 20}};
        int k = 1;
        int[][] expected = {{10, 20}, {40, 30}};
        System.out.println("Original:");
        printMatrix(grid, "\t");
        testingClass.rotateGrid(grid, k);
        System.out.println("Current:");
        printMatrix(grid, "\t");
        System.out.println("Expected:");
        printMatrix(expected, "\t");
        assertTrue(areMatrixEquals(expected, grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int k = 2;
        int[][] expected = {{3, 4, 8, 12}, {2, 11, 10, 16}, {1, 7, 6, 15}, {5, 9, 13, 14}};
        System.out.println("Original:");
        printMatrix(grid, "\t");
        testingClass.rotateGrid(grid, k);
        System.out.println("Current:");
        printMatrix(grid, "\t");
        System.out.println("Expected:");
        printMatrix(expected, "\t");
        assertTrue(areMatrixEquals(expected, grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {
                {4, 5, 8, 9, 4, 2, 4, 7, 2, 4},
                {7, 1, 9, 6, 6, 1, 4, 5, 7, 7},
                {7, 1, 5, 1, 1, 7, 10, 1, 3, 1},
                {7, 2, 2, 5, 2, 6, 6, 4, 7, 7},
                {1, 2, 3, 8, 4, 7, 6, 9, 6, 2},
                {5, 10, 3, 4, 7, 2, 7, 5, 3, 10}
        };
        int k = 4;
        int[][] expected = {{4, 2, 4, 7, 2, 4, 7, 1, 7, 2}, {9, 1, 4, 5, 7, 3, 7, 6, 9, 10}, {8, 6, 10, 1, 4, 6, 6, 2, 6, 3}, {5, 6, 7, 1, 1, 5, 2, 5, 7, 5}, {4, 9, 1, 1, 2, 2, 3, 8, 4, 7}, {7, 7, 7, 1, 5, 10, 3, 4, 7, 2}};
        System.out.println("Original:");
        printMatrix(grid, "\t");
        testingClass.rotateGrid(grid, k);
        System.out.println("Current:");
        printMatrix(grid, "\t");
        System.out.println("Expected:");
        printMatrix(expected, "\t");
        assertTrue(areMatrixEquals(expected, grid));
    }
}
