package matrix.workingPeoplesImitation.task_1679_Max_Number_of_KSum_Pairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] nums = {1,2,3,4};
        int k = 5;
        int expected = 2;
        assertEquals(expected, testingClass.maxOperations(nums, k));
    }

    @Test
    public void makeTestcase2() {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        int expected = 1;
        assertEquals(expected, testingClass.maxOperations(nums, k));
    }

    @Test
    public void makeTestcase3() {
        int[] nums = {2,2,2,3,1,1,4,1};
        int k = 4;
        int expected = 2;
        assertEquals(expected, testingClass.maxOperations(nums, k));
    }

    @Test
    public void makeTestcase4() { // 22 / 51 testcases passed
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;
        int expected = 4;
        assertEquals(expected, testingClass.maxOperations(nums, k));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int k = 5;
        int result = testingClass.maxOperations(nums, k);
        assertEquals(0, result);
    }

    @Test
    public void testNoPairsSummingToK() {
        int[] nums = {1, 2, 3, 4};
        int k = 10;
        int result = testingClass.maxOperations(nums, k);
        assertEquals(0, result);
    }

    @Test
    public void testDuplicateNumbers() {
        int[] nums = {2, 2, 3, 3, 4, 4};
        int k = 6;
        int result = testingClass.maxOperations(nums, k);
        assertEquals(3, result);
    }

    @Test
    public void testLargeInput() {
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i + 1;
        }
        int k = 10002;
        int result = testingClass.maxOperations(nums, k);
        assertEquals(4999, result);
    }
}
