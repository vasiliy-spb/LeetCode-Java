package matrix.workingPeoplesImitation.task_994_Rotting_Oranges;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        assertEquals(expected, testingClass.orangesRotting(grid));
    }

    @Test
    public void checkTestcase2() {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        assertEquals(expected, testingClass.orangesRotting(grid));
    }

    @Test
    public void checkTestcase3() {
        int[][] grid = {{0, 2}};
        int expected = 0;
        assertEquals(expected, testingClass.orangesRotting(grid));
    }

    @Test
    public void checkTestcase4() { // 304 / 306 testcases passed
        int[][] grid = {{0}};
        int expected = 0;
        assertEquals(expected, testingClass.orangesRotting(grid));
    }

}
