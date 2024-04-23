package matrix.workingPeoplesImitation.task_189_Rotate_Array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        testingClass.rotate(nums, k);
        System.out.println("nums is =  " + Arrays.toString(nums));
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, nums);
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        testingClass.rotate(nums, k);
        System.out.println("nums is =  " + Arrays.toString(nums));
        int[] expected = {3, 99, -1, -100};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, nums);
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 4;
        testingClass.rotate(nums, k);
        System.out.println("nums is =  " + Arrays.toString(nums));
        int[] expected = {6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, nums);
    }
}
