package matrix.workingPeoplesImitation.task_2017_Grid_Game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {
                {2, 5, 4},
                {1, 5, 1}
        };
        int expected = 4;
        assertEquals(expected, testingClass.gridGame(grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {{3, 3, 1}, {8, 5, 2}};
        int expected = 4;
        assertEquals(expected, testingClass.gridGame(grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {{1, 3, 1, 15}, {1, 3, 3, 1}};
        int expected = 7;
        assertEquals(expected, testingClass.gridGame(grid));
    }

    @Test
    public void checkTestcase04() {
        int[][] grid = {
                {20,  3, 20, 17,  2, 12, 15, 17,  4, 15},
                {20, 10, 13, 14, 15,  5,  2,  3, 14,  3}
        };
        int expected = 63;
        assertEquals(expected, testingClass.gridGame(grid));
    }

    @Test
    public void checkTestcase05() {
        int[][] grid = {
                {1, 3, 1, 15},
                {1, 3, 14, 1}
        };
        int expected = 15;
        assertEquals(expected, testingClass.gridGame(grid));
    }
}
