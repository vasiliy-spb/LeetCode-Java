package matrix.workingPeoplesImitation.task_1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {5, 3, 2, 4};
        int expected = 0;
        assertEquals(expected, testingClass.minDifference(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {1, 5, 0, 10, 14};
        int expected = 1;
        assertEquals(expected, testingClass.minDifference(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {3, 100, 20};
        int expected = 0;
        assertEquals(expected, testingClass.minDifference(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {6, 6, 0, 1, 1, 4, 6};
        int expected = 2;
        assertEquals(expected, testingClass.minDifference(nums));
    }

    @Test
    public void checkTestcase05() {
        int[] nums = {1, 5, 6, 14, 15};
        int expected = 1;
        assertEquals(expected, testingClass.minDifference(nums));
    }

    @Test
    public void checkTestcase06() {
        int[] nums = {9, 48, 92, 48, 81, 31};
        int expected = 17;
        assertEquals(expected, testingClass.minDifference(nums));
    }
}
