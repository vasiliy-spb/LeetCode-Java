package matrix.workingPeoplesImitation.task_303_Range_Sum_Query_Immutable;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumArrayTest {

    @Test
    public void testSumRange() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }

    @Test
    public void testSumRangeWithSingleElement() {
        int[] nums = {5};
        NumArray numArray = new NumArray(nums);

        assertEquals(5, numArray.sumRange(0, 0));
    }

    @Test
    public void testSumRangeWithAllNegativeElements() {
        int[] nums = {-1, -2, -3, -4, -5};
        NumArray numArray = new NumArray(nums);

        assertEquals(-1, numArray.sumRange(0, 0));
        assertEquals(-5, numArray.sumRange(1, 2));
        assertEquals(-15, numArray.sumRange(0, 4));
    }

    @Test
    public void testSumRangeWithAllPositiveElements() {
        int[] nums = {1, 2, 3, 4, 5};
        NumArray numArray = new NumArray(nums);

        assertEquals(1, numArray.sumRange(0, 0));
        assertEquals(3, numArray.sumRange(0, 1));
        assertEquals(15, numArray.sumRange(0, 4));
    }
}
