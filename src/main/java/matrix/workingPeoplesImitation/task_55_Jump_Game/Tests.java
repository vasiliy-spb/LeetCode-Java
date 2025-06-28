package matrix.workingPeoplesImitation.task_55_Jump_Game;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {2, 3, 1, 1, 4};
        assertTrue(testingClass.canJump(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {3, 2, 1, 0, 4};
        assertFalse(testingClass.canJump(nums));
    }

    @Test
    public void checkTestcase3() { // 129 / 172 testcases passed
        int[] nums = {1, 2, 3};
        assertTrue(testingClass.canJump(nums));
    }

    @Test
    public void checkTestcase4() { // 135 / 172 testcases passed
        int[] nums = {1, 1, 1, 0};
        assertTrue(testingClass.canJump(nums));
    }

    @Test
    public void checkTestcase5() { // 150 / 172 testcases passed
        int[] nums = {1, 1, 2, 2, 0, 1, 1};
        assertTrue(testingClass.canJump(nums));
    }

    @Test
    public void checkTestcase6() { // 171 / 172 testcases passed
        int[] nums = {4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0};
        assertTrue(testingClass.canJump(nums));
    }

    @Test
    public void checkTestcase7() { // 168 / 172 testcases passed
        int[] nums = {3, 0, 8, 2, 0, 0, 1};
        assertTrue(testingClass.canJump(nums));
    }

    @Test
    public void checkTestcase8() { // 170 / 172 testcases passed
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        assertTrue(testingClass.canJump(nums));
    }
}
