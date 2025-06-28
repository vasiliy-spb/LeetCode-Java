package matrix.workingPeoplesImitation.task_645_Set_Mismatch;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1, 2, 2, 4};
        int[] expected = {2, 3};
        assertArrayEquals(expected, testingClass.findErrorNums(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {1, 1};
        int[] expected = {1, 2};
        assertArrayEquals(expected, testingClass.findErrorNums(nums));
    }

    @Test
    public void checkTestcase3() { // 11 / 49 testcases passed
        int[] nums = {3, 2, 2};
        int[] expected = {2, 1};
        assertArrayEquals(expected, testingClass.findErrorNums(nums));
    }

    @Test
    public void checkTestcase4() { // 18 / 49 testcases passed
        int[] nums = {3, 2, 3, 4, 6, 5};
        int[] expected = {3, 1};
        assertArrayEquals(expected, testingClass.findErrorNums(nums));
    }

}
