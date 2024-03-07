package matrix.workingPeoplesImitation.task_136_Single_Number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {2, 2, 1};
        int expected = 1;
        assertEquals(expected, testingClass.singleNumber(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {4, 1, 2, 1, 2};
        int expected = 4;
        assertEquals(expected, testingClass.singleNumber(nums));
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {1};
        int expected = 1;
        assertEquals(expected, testingClass.singleNumber(nums));
    }

}
