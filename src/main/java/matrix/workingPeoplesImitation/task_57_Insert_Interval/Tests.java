package matrix.workingPeoplesImitation.task_57_Insert_Interval;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] expected = {{1, 5}, {6, 9}};
        assertArrayEquals(expected, testingClass.insert(intervals, newInterval));
    }

    @Test
    public void checkTestcase2() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        assertArrayEquals(expected, testingClass.insert(intervals, newInterval));
    }

    @Test
    public void checkTestcase3() {
        int[][] intervals = {};
        int[] newInterval = {5, 7};
        int[][] expected = {{5, 7}};
        assertArrayEquals(expected, testingClass.insert(intervals, newInterval));
    }

    @Test
    public void checkTestcase4() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] expected = {{1, 7}};
        assertArrayEquals(expected, testingClass.insert(intervals, newInterval));
    }

    @Test
    public void checkTestcase5() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {6, 8};
        int[][] expected = {{1, 5}, {6, 8}};
        assertArrayEquals(expected, testingClass.insert(intervals, newInterval));
    }

    @Test
    public void checkTestcase6() {
        int[][] intervals = {{3, 5}, {12, 15}};
        int[] newInterval = {6, 6};
        int[][] expected = {{3, 5}, {6, 6}, {12, 15}};
        assertArrayEquals(expected, testingClass.insert(intervals, newInterval));
    }

}
