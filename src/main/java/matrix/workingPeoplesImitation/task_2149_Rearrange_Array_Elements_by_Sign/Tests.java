package matrix.workingPeoplesImitation.task_2149_Rearrange_Array_Elements_by_Sign;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] expected = {3, -2, 1, -5, 2, -4};
        assertArrayEquals(expected, testingClass.rearrangeArray(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {-1, 1};
        int[] expected = {1, -1};
        assertArrayEquals(expected, testingClass.rearrangeArray(nums));
    }

}
