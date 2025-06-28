package matrix.workingPeoplesImitation.task_1895_Largest_Magic_Square;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};
        int expected = 3;
        assertEquals(expected, testingClass.largestMagicSquare(grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {{5, 1, 3, 1}, {9, 3, 3, 1}, {1, 3, 3, 8}};
        int expected = 2;
        assertEquals(expected, testingClass.largestMagicSquare(grid));
    }

//    @Test
//    public void checkTestcase03() {
//
//    }
}
