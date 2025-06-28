package matrix.workingPeoplesImitation.task_1568_Minimum_Number_of_Days_to_Disconnect_Island;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int expected = 2;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {{1, 1}};
        int expected = 2;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {{1, 1, 1}};
        int expected = 1;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase04() {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1}};
        int expected = 1;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase05() {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1}
        };
        int expected = 2;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase06() {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int expected = 0;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase07() {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0},
        };
        int expected = 0;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase08() {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int expected = 1;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase09() {
        int[][] grid = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int expected = 2;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase10() {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        int expected = 1;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase11() {
        int[][] grid = {
                {1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int expected = 1;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase12() {
        int[][] grid = {{0, 0}};
        int expected = 0;
        assertEquals(expected, testingClass.minDays(grid));
    }

    @Test
    public void checkTestcase13() {
        int[][] grid = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        int expected = 1;
        assertEquals(expected, testingClass.minDays(grid));
    }
}
