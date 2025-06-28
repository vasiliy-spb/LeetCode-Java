package matrix.workingPeoplesImitation.task_3047_Find_the_Largest_Area_of_Square_Inside_Two_Rectangles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] bottomLeft = {{1, 1}, {2, 2}, {3, 1}};
        int[][] topRight = {{3, 3}, {4, 4}, {6, 6}};
        int expected = 1;
        assertEquals(expected, testingClass.largestSquareArea(bottomLeft, topRight));
    }

    @Test
    public void checkTestcase02() {
        int[][] bottomLeft = {{1, 1}, {1, 3}, {1, 5}};
        int[][] topRight = {{5, 5}, {5, 7}, {5, 9}};
        int expected = 4;
        assertEquals(expected, testingClass.largestSquareArea(bottomLeft, topRight));
    }

    @Test
    public void checkTestcase03() {
        int[][] bottomLeft = {{1, 1}, {2, 2}, {1, 2}};
        int[][] topRight = {{3, 3}, {4, 4}, {3, 4}};
        int expected = 1;
        assertEquals(expected, testingClass.largestSquareArea(bottomLeft, topRight));
    }

    @Test
    public void checkTestcase04() {
        int[][] bottomLeft = {{1, 1}, {3, 3}, {3, 1}};
        int[][] topRight = {{2, 2}, {4, 4}, {4, 2}};
        int expected = 0;
        assertEquals(expected, testingClass.largestSquareArea(bottomLeft, topRight));
    }
}
