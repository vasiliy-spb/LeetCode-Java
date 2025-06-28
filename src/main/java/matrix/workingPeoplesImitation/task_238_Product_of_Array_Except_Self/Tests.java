package matrix.workingPeoplesImitation.task_238_Product_of_Array_Except_Self;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, testingClass.productExceptSelf(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        assertArrayEquals(expected, testingClass.productExceptSelf(nums));
    }

    @Test
    public void testCustomInput1() {
        int[] nums = {2, 4, 6, 8};
        int[] expected = {192, 96, 64, 48};
        assertArrayEquals(expected, testingClass.productExceptSelf(nums));
    }

    @Test
    public void testCustomInput2() {
        int[] nums = {-5, 5, -5, 5};
        int[] expected = {-125, 125, -125, 125};
        assertArrayEquals(expected, testingClass.productExceptSelf(nums));
    }

    @Test
    public void testEdgeCase() {
        int[] nums = {2, 0, 4, 1};
        int[] expected = {0, 8, 0, 0};
        assertArrayEquals(expected, testingClass.productExceptSelf(nums));
    }
}
