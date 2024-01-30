package matrix.workingPeoplesImitation.task_75_Sort_Colors;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        testingClass.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {2, 0, 1};
        int[] expected = {0, 1, 2};
        testingClass.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void checkTestcase3() { // 44 / 87 testcases passed
        int[] nums = {1, 2, 0};
        int[] expected = {0, 1, 2};
        testingClass.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void checkTestcase4() {
        int[] nums = {2, 0, 2, 1, 1, 0, 2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2};
        testingClass.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void checkTestcase5() { // 52 / 87 testcases passed
        int[] nums = {2, 1, 2};
        int[] expected = {1, 2, 2};
        testingClass.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

}
