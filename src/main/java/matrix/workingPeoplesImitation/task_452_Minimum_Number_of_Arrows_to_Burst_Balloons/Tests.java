package matrix.workingPeoplesImitation.task_452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int expected = 2;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

    @Test
    public void checkTestcase2() {
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int expected = 4;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

    @Test
    public void checkTestcase3() {
        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int expected = 2;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

    @Test
    public void checkTestcase4() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}, {11, 13}};
        int expected = 2;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

    @Test
    public void checkTestcase5() { // 10 / 50 testcases passed
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int expected = 2;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

    @Test
    public void checkTestcase6() { // 11 / 50 testcases passed
        int[][] points = {{1, 2}, {4, 5}, {1, 5}};
        int expected = 2;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

    @Test
    public void checkTestcase7() { // 11 / 50 testcases passed
        int[][] points = {{2, 3}, {2, 3}};
        int expected = 1;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

    @Test
    public void checkTestcase8() { // 11 / 50 testcases passed
        int[][] points = {{-1, 1}, {0, 1}, {2, 3}, {1, 2}};
        int expected = 2;
        assertEquals(expected, testingClass.findMinArrowShots(points));
    }

}
