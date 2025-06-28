package matrix.workingPeoplesImitation.task_525_Contiguous_Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] nums = {0,1};
        int expected = 2;
        assertEquals(expected, testingClass.findMaxLength(nums));
    }

    @Test
    public void makeTestcase2() {
        int[] nums = {0,1,0};
        int expected = 2;
        assertEquals(expected, testingClass.findMaxLength(nums));
    }

    @Test
    public void makeTestcase3() { // 139 / 564 testcases passed
        int[] nums = {0,1,0,1};
        int expected = 4;
        assertEquals(expected, testingClass.findMaxLength(nums));
    }

    @Test
    public void makeTestcase4() { // 344 / 564 testcases passed
        int[] nums = {0,0,1,0,0,0,1,1};
        int expected = 6;
        assertEquals(expected, testingClass.findMaxLength(nums));
    }

    @Test
    public void makeTestcase5() {
        int[] nums = {1,1,0,1,1,1,0,0};
        int expected = 6;
        assertEquals(expected, testingClass.findMaxLength(nums));
    }

    @Test
    public void makeTestcase6() { // 451 / 564 testcases passed
        int[] nums = {0,1,1,0,1,1,1,0};
        int expected = 4;
        assertEquals(expected, testingClass.findMaxLength(nums));
    }

    @Test
    public void makeTestcase7() {
        int[] nums = {1,0,0,1,0,0,0,1};
        int expected = 4;
        assertEquals(expected, testingClass.findMaxLength(nums));
    }

}
