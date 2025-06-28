package matrix.workingPeoplesImitation.task_2348_Number_of_Zero_Filled_Subarrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        int expected = 6;
        assertEquals(expected, testingClass.zeroFilledSubarray(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {0, 0, 0, 2, 0, 0};
        int expected = 9;
        assertEquals(expected, testingClass.zeroFilledSubarray(nums));
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {2, 10, 2019};
        int expected = 0;
        assertEquals(expected, testingClass.zeroFilledSubarray(nums));
    }

}
