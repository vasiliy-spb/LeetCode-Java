package matrix.workingPeoplesImitation.task_240_Search_a_2D_Matrix_II;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        assertTrue(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase02() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 20;
        assertFalse(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase03() {
        int[][] matrix = {{-5}};
        int target = -2;
        assertFalse(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase04() {
        int[][] matrix = {{1, 4}, {2, 5}};
        int target = 2;
        assertTrue(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase05() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int target = 15;
        assertTrue(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase06() {
        int[][] matrix = {
                {1,  3,  5,  7,  9},
                {2,  4,  6,  8,  10},
                {11, 13, 15, 17, 19},
                {12, 14, 16, 18, 20},
                {21, 22, 23, 24, 25}
        };
        int target = 11;
        assertTrue(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase07() {
        int[][] matrix = {{-1, 3}};
        int target = 3;
        assertTrue(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase08() {
        int[][] matrix = {{-1, -1}};
        int target = 0;
        assertFalse(testingClass.searchMatrix(matrix, target));
    }

    @Test
    public void checkTestcase09() {
        int[][] matrix = {{-5}, {6}};
        int target = 6;
        assertTrue(testingClass.searchMatrix(matrix, target));
    }
}
