package matrix.workingPeoplesImitation.task_3011_Find_if_Array_Can_Be_Sorted;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {8, 4, 2, 30, 15};
        assertTrue(testingClass.canSortArray(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {1, 2, 3, 4, 5};
        assertTrue(testingClass.canSortArray(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {3, 16, 8, 4, 2};
        assertFalse(testingClass.canSortArray(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {2, 28, 9};
        assertFalse(testingClass.canSortArray(nums));
    }
}
