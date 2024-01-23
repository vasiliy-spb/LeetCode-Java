package matrix.workingPeoplesImitation.task_287_Find_the_Duplicate_Number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1, 3, 4, 2, 2};
        int expected = 2;
        assertEquals(expected, testingClass.findDuplicate(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {3, 1, 3, 4, 2};
        int expected = 3;
        assertEquals(expected, testingClass.findDuplicate(nums));
    }

    @Test
    public void checkTestcase3() { // 16 / 58 testcases passed
        int[] nums = {2, 2, 2, 2, 2};
        int expected = 2;
        assertEquals(expected, testingClass.findDuplicate(nums));
    }

    @Test
    public void checkTestcase4() { // 28 / 58 testcases passed
        int[] nums = {1, 4, 4, 2, 4};
        int expected = 4;
        assertEquals(expected, testingClass.findDuplicate(nums));
    }

    @Test
    public void checkTestcase5() {
        int[] nums = {1, 3, 4, 2, 0};
        int expected = 2;
        assertEquals(expected, testingClass.findDuplicate(nums));
    }

}
