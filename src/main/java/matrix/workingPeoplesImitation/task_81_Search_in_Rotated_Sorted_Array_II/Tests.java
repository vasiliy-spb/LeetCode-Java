package matrix.workingPeoplesImitation.task_81_Search_in_Rotated_Sorted_Array_II;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        assertTrue(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 3;
        assertFalse(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {1};
        int target = 0;
        assertFalse(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase4() {
        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;
        assertTrue(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase5() {
        int[] nums = {2, 2, 2, 3, 2, 2, 2};
        int target = 3;
        assertTrue(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase6() {
        int[] nums = {1, 1};
        int target = 0;
        assertFalse(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase7() {
        int[] nums = {1, 3};
        int target = 0;
        assertFalse(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase8() {
        int[] nums = {1, 2, 1};
        int target = 1;
        assertTrue(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase9() {
        int[] nums = {3, 5, 1};
        int target = 5;
        assertTrue(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase10() {
        int[] nums = {3, 1, 1, 1, 1};
        int target = 3;
        assertTrue(testingClass.search(nums, target));
    }

    @Test
    public void checkTestcase11() {
        int[] nums = {2, 2, 3, 3, 0, 1, 1};
        int target = 0;
        assertTrue(testingClass.search(nums, target));
    }
}
