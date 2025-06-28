package matrix.workingPeoplesImitation.task_1162_As_Far_from_Land_as_Possible;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int expected = 2;
        assertEquals(expected, testingClass.maxDistance(grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int expected = 4;
        assertEquals(expected, testingClass.maxDistance(grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}
        };
        int expected = 2;
        assertEquals(expected, testingClass.maxDistance(grid));
    }

    @Test
    public void checkTestcase04() {
        int[][] grid = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int expected = -1;
        assertEquals(expected, testingClass.maxDistance(grid));
    }
}
