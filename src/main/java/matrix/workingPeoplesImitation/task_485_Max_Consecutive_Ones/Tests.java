package matrix.workingPeoplesImitation.task_485_Max_Consecutive_Ones;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] nums = {1,1,0,1,1,1};
        int expected = 3;
        assertEquals(expected, testingClass.findMaxConsecutiveOnes(nums));
    }

    @Test
    public void makeTestcase2() {
        int[] nums = {1,0,1,1,0,1};
        int expected = 2;
        assertEquals(expected, testingClass.findMaxConsecutiveOnes(nums));
    }

}
