package matrix.workingPeoplesImitation.task_2352_Equal_Row_and_Column_Pairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void testExample1() {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        assertEquals(1, testingClass.equalPairs(grid));
    }

    @Test
    public void testExample2() {
        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        assertEquals(3, testingClass.equalPairs(grid));
    }

    @Test
    public void testExample3() { // 25 / 79 testcases passed
        int[][] grid = {
                {3,1,2,2},
                {1,4,4,4},
                {2,4,2,2},
                {2,5,2,2}};
        assertEquals(3, testingClass.equalPairs(grid));
    }

    @Test
    public void testEmptyGrid() {
        int[][] grid = {};
        assertEquals(0, testingClass.equalPairs(grid));
    }

    @Test
    public void testSingleElementGrid() {
        int[][] grid = {{5}};
        assertEquals(1, testingClass.equalPairs(grid));
    }

    @Test
    public void testAllElementsAreTheSame() {
        int[][] grid = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        assertEquals(9, testingClass.equalPairs(grid));
    }

    @Test
    public void testNoEqualRowColumnPairs() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(0, testingClass.equalPairs(grid));
    }

    @Test
    public void testLargeGrid() {
        int n = 200;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = i + j;
            }
        }
        assertEquals(200, testingClass.equalPairs(grid));
    }
}
