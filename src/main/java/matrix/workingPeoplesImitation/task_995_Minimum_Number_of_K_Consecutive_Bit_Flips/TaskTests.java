package matrix.workingPeoplesImitation.task_995_Minimum_Number_of_K_Consecutive_Bit_Flips;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {0, 1, 0};
        int k = 1;
        int expected = 2;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {1, 1, 0};
        int k = 2;
        int expected = -1;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;
        int expected = 3;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = new int[100_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2;
        }
        int k = 50001;
        int expected = -1;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase05() {
        int[] nums = {1, 1};
        int k = 2;
        int expected = 0;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase06() {
        int[] nums = {0, 0};
        int k = 2;
        int expected = 1;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase07() {
        int[] nums = {1, 0, 0};
        int k = 2;
        int expected = 1;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase08() {
        int[] nums = {0, 1, 0};
        int k = 2;
        int expected = 2;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase09() {
        int[] nums = new int[100_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2;
        }
        int k = 50000;
        int expected = 50000;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }

    @Test
    public void checkTestcase10() {
        int[] nums = {1, 0};
        int k = 2;
        int expected = -1;
        assertEquals(expected, testingClass.minKBitFlips(nums, k));
    }
}
