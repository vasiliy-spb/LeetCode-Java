package matrix.workingPeoplesImitation.task_153_Find_Minimum_in_Rotated_Sorted_Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {3, 4, 5, 1, 2};
        int expected = 1;
        assertEquals(expected, testingClass.findMin(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;
        assertEquals(expected, testingClass.findMin(nums));
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {11, 13, 15, 17};
        int expected = 11;
        assertEquals(expected, testingClass.findMin(nums));
    }
}
