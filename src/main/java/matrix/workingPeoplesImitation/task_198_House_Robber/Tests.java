package matrix.workingPeoplesImitation.task_198_House_Robber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1, 2, 3, 1};
        int expected = 4;
        assertEquals(expected, testingClass.rob(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {2, 7, 9, 3, 1};
        int expected = 12;
        assertEquals(expected, testingClass.rob(nums));
    }

}
