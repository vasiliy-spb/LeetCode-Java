package matrix.workingPeoplesImitation.task_1493_Longest_Subarray_of_1s_After_Deleting_One_Element;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] nums = {1,1,0,1};
        int expected = 3;
        assertEquals(expected, testingClass.longestSubarray(nums));
    }

    @Test
    public void makeTestcase2() {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int expected = 5;
        assertEquals(expected, testingClass.longestSubarray(nums));
    }

    @Test
    public void makeTestcase3() {
        int[] nums = {1,1,1};
        int expected = 2;
        assertEquals(expected, testingClass.longestSubarray(nums));
    }

    @Test
    public void makeTestcase4() {
        int[] nums = {0,0,0};
        int expected = 0;
        assertEquals(expected, testingClass.longestSubarray(nums));
    }

    @Test
    public void makeTestcase5() {
        int[] nums = {1, 1, 1, 1, 0, 0, 1, 1};
        int expected = 4;
        assertEquals(expected, testingClass.longestSubarray(nums));
    }

    @Test
    public void makeTestcase6() {
        int[] nums = {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        int expected = 5;
        assertEquals(expected, testingClass.longestSubarray(nums));
    }

}
