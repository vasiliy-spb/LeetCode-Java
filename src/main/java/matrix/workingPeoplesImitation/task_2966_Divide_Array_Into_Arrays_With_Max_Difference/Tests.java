package matrix.workingPeoplesImitation.task_2966_Divide_Array_Into_Arrays_With_Max_Difference;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        int[][] expected = {{1, 1, 3}, {3, 4, 5}, {7, 8, 9}};
        assertArrayEquals(expected, testingClass.divideArray(nums, k));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {1, 3, 3, 2, 7, 3};
        int k = 3;
        int[][] expected = {};
        assertArrayEquals(expected, testingClass.divideArray(nums, k));
    }

}
