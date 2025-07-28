package matrix.workingPeoplesImitation.task_2210_Count_Hills_and_Valleys_in_an_Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {2, 4, 1, 1, 6, 5};
        int expected = 3;
        assertEquals(expected, testingClass.countHillValley(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {6, 6, 5, 5, 4, 1};
        int expected = 0;
        assertEquals(expected, testingClass.countHillValley(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {2, 1, 1, 1, 2};
        int expected = 1;
        assertEquals(expected, testingClass.countHillValley(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {8, 2, 5, 7, 7, 2, 10, 3, 6, 2};
        int expected = 6;
        assertEquals(expected, testingClass.countHillValley(nums));
    }
}
