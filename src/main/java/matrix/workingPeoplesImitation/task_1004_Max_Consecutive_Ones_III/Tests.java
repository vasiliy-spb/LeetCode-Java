package matrix.workingPeoplesImitation.task_1004_Max_Consecutive_Ones_III;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int expected = 6;
        assertEquals(expected, testingClass.longestOnes(nums, k));
    }

    @Test
    public void makeTestcase2() {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int expected = 10;
        assertEquals(expected, testingClass.longestOnes(nums, k));
    }

    @Test
    public void makeTestcase3() {
        int[] nums = {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1};
        int k = 2;
        int expected = 6;
        assertEquals(expected, testingClass.longestOnes(nums, k));
    }

    @Test
    public void makeTestcase4() { // 2 / 55 testcases passed
        int[] nums = {0,0,1,1,1,0,0};
        int k = 0;
        int expected = 3;
        assertEquals(expected, testingClass.longestOnes(nums, k));
    }

    @Test
    public void makeTestcase5() {
        int[] nums = {1,1,1,0};
        int k = 1;
        int expected = 4;
        assertEquals(expected, testingClass.longestOnes(nums, k));
    }

    @Test
    public void makeTestcase6() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 0;
        int expected = 4;
        assertEquals(expected, testingClass.longestOnes(nums, k));
    }

}
