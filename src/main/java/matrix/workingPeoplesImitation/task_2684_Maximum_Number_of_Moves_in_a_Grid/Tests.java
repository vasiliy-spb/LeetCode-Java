package matrix.workingPeoplesImitation.task_2684_Maximum_Number_of_Moves_in_a_Grid;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        int expected = 3;
        assertEquals(expected, testingClass.maxMoves(grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}
        };
        int expected = 0;
        assertEquals(expected, testingClass.maxMoves(grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {
                {2, 4, 3, 5, 4},
                {5, 4, 9, 3, 8},
                {3, 4, 2, 11, 6},
                {10, 9, 13, 15, 12}
        };
        int expected = 4;
        assertEquals(expected, testingClass.maxMoves(grid));
    }

    @Test
    public void checkTestcase04() {
        int[][] grid = {
                {2, 4,  3,  5,   4},
                {5, 4,  9,  3,   8},
                {3, 4,  2,  11,  6},
                {10, 9, 13, 15, 11}
        };
        int expected = 3;
        assertEquals(expected, testingClass.maxMoves(grid));
    }

    @Test
    public void checkTestcase05() {
        int[][] grid = {
                {2, 4, 3, 5, 4, 6, 19, 3},
                {5, 4, 9, 3, 8, 4, 16, 2},
                {3, 4, 2, 11, 6, 14, 5, 10},
                {10, 9, 13, 15, 12, 11, 8, 20}
        };
        int expected = 6;
        assertEquals(expected, testingClass.maxMoves(grid));
    }
}
