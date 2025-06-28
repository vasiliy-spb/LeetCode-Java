package matrix.workingPeoplesImitation.task_1034_Coloring_A_Border;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {{1, 1}, {1, 2}};
        int row = 0;
        int col = 0;
        int color = 3;
        int[][] expected = {{3, 3}, {3, 2}};
        testingClass.colorBorder(grid, row, col, color);
        System.out.println("In real:");
        printMatrix(grid);
        System.out.println("Expected:");
        printMatrix(expected);
        assertTrue(areMatrixEquals(expected, grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {
                {1, 2, 2},
                {2, 3, 2}
        };
        int row = 0;
        int col = 1;
        int color = 3;
        int[][] expected = {{1, 3, 3}, {2, 3, 3}};
        testingClass.colorBorder(grid, row, col, color);
        System.out.println("In real:");
        printMatrix(grid);
        System.out.println("Expected:");
        printMatrix(expected);
        assertTrue(areMatrixEquals(expected, grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int row = 1;
        int col = 1;
        int color = 2;
        int[][] expected = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        testingClass.colorBorder(grid, row, col, color);
        System.out.println("In real:");
        printMatrix(grid);
        System.out.println("Expected:");
        printMatrix(expected);
        assertTrue(areMatrixEquals(expected, grid));
    }

    @Test
    public void checkTestcase04() {
        int[][] grid = {{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}};
        int row = 1;
        int col = 3;
        int color = 1;
        int[][] expected = {{1, 1, 1, 1, 1, 2}, {1, 2, 1, 1, 1, 2}, {1, 1, 1, 1, 1, 2}};
        System.out.println("Origin:");
        printMatrix(grid);
        testingClass.colorBorder(grid, row, col, color);
        System.out.println("In real:");
        printMatrix(grid);
        System.out.println("Expected:");
        printMatrix(expected);
        assertTrue(areMatrixEquals(expected, grid));
    }

    private boolean areMatrixEquals(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
