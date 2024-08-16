package matrix.workingPeoplesImitation.task_2556_Disconnect_Path_in_a_Binary_Matrix_by_at_Most_One_Flip;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
        private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        int[][] grid = {{1, 1, 1}, {1, 0, 0}, {1, 1, 1}};
        assertTrue(testingClass.isPossibleToCutPath(grid));
    }

    @Test
    public void checkTestcase02() {
        int[][] grid = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        assertFalse(testingClass.isPossibleToCutPath(grid));
    }

    @Test
    public void checkTestcase03() {
        int[][] grid = {
                {1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1}};
        assertTrue(testingClass.isPossibleToCutPath(grid));
    }

    @Test
    public void checkTestcase04() {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        assertFalse(testingClass.isPossibleToCutPath(grid));
    }

    @Test
    public void checkTestcase05() {
        int[][] grid = {
                {1, 1, 1, 1, 1},
        };
        assertTrue(testingClass.isPossibleToCutPath(grid));
    }

    @Test
    public void checkTestcase06() {
        int[][] grid = {
                {1, 1},
        };
        assertFalse(testingClass.isPossibleToCutPath(grid));
    }

    @Test
    public void checkTestcase07() {
        int[][] grid = {
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
        };
        assertTrue(testingClass.isPossibleToCutPath(grid));
    }

    @Test
    public void checkTestcase08() {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1, 1}
        };
        assertTrue(testingClass.isPossibleToCutPath(grid));
    }
}
