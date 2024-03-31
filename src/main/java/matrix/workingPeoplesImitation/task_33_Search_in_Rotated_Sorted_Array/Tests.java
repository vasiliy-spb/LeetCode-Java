package matrix.workingPeoplesImitation.task_33_Search_in_Rotated_Sorted_Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4;
        assertEquals(expected, testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1;
        assertEquals(expected, testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {1};
        int target = 0;
        int expected = -1;
        assertEquals(expected, testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase4() {
        int[] nums = {1, 2};
        int target = 0;
        int expected = -1;
        assertEquals(expected, testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase5() { // 119 / 195 testcases passed
        int[] nums = {1, 3};
        int target = 3;
        int expected = 1;
        assertEquals(expected, testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase6() { // 182 / 195 testcases passed
        int[] nums = {3, 1};
        int target = 1;
        int expected = 1;
        assertEquals(expected, testingClass.search(nums, target));
    }
}
