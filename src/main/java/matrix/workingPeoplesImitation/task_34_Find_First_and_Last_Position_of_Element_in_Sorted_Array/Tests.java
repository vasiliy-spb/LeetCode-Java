package matrix.workingPeoplesImitation.task_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = new int[]{3, 4};
        assertArrayEquals(expected, testingClass.searchRange(nums, target));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = new int[]{-1, -1};
        assertArrayEquals(expected, testingClass.searchRange(nums, target));
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {};
        int target = 0;
        int[] expected = new int[]{-1, -1};
        assertArrayEquals(expected, testingClass.searchRange(nums, target));
    }

}
