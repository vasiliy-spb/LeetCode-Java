package matrix.workingPeoplesImitation.task_1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {3,5};
        int expected = 2;
        assertEquals(expected, testingClass.specialArray(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {0,0};
        int expected = -1;
        assertEquals(expected, testingClass.specialArray(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {0,4,3,0,4};
        int expected = 3;
        assertEquals(expected, testingClass.specialArray(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {3,6,7,7,0};
        int expected = -1;
        assertEquals(expected, testingClass.specialArray(nums));
    }

    @Test
    public void checkTestcase05() {
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        int expected = 100;
        assertEquals(expected, testingClass.specialArray(nums));
    }
}
