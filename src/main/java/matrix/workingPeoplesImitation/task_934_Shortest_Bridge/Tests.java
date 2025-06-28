package matrix.workingPeoplesImitation.task_934_Shortest_Bridge;

import org.junit.Test;

import static matrix.workingPeoplesImitation.utils.MatrixUtils.readMatrixFromFile;
import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {{0, 1}, {1, 0}};
        int expected = 1;
        assertEquals(expected, testingClass.shortestBridge(grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        int expected = 2;
        assertEquals(expected, testingClass.shortestBridge(grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        int expected = 1;
        assertEquals(expected, testingClass.shortestBridge(grid));
    }

    @Test
    public void checkTestcase04() {
        int[][] grid = readMatrixFromFile("src/main/java/matrix/workingPeoplesImitation/task_934_Shortest_Bridge/testcase4.txt");
        int expected = 31;
        assertEquals(expected, testingClass.shortestBridge(grid));
    }
}
