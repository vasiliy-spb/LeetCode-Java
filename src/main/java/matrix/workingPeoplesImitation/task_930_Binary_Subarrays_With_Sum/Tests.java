package matrix.workingPeoplesImitation.task_930_Binary_Subarrays_With_Sum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        int expected = 4;
        assertEquals(expected, testingClass.numSubarraysWithSum(nums, goal));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {0,0,0,0,0};
        int goal = 0;
        int expected = 15;
        assertEquals(expected, testingClass.numSubarraysWithSum(nums, goal));
    }

//    @Test
//    public void checkTestcase3() {
//        int[] nums = {};
//        int goal = 0;
//        int expected = 0;
//        assertEquals(expected, testingClass.numSubarraysWithSum(nums, goal));
//    }
}
