package matrix.workingPeoplesImitation.task_3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {5, 2, 5, 4, 5};
        int k = 2;
        int expected = 2;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {2, 1, 2};
        int k = 2;
        int expected = -1;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {9, 7, 5, 3};
        int k = 1;
        int expected = 4;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {9, 10, 9};
        int k = 6;
        int expected = 2;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }

    @Test
    public void checkTestcase05() {
        int[] nums = {9, 9, 9};
        int k = 6;
        int expected = 1;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }

    @Test
    public void checkTestcase06() {
        int[] nums = {9, 9, 9};
        int k = 19;
        int expected = -1;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }

    @Test
    public void checkTestcase07() {
        int[] nums = {4, 4, 4};
        int k = 4;
        int expected = 0;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }

    @Test
    public void checkTestcase08() {
        int[] nums = {4};
        int k = 4;
        int expected = 0;
        assertEquals(expected, testingClass.minOperations(nums, k));
    }
}
