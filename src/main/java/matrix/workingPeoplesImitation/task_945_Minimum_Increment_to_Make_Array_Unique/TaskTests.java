package matrix.workingPeoplesImitation.task_945_Minimum_Increment_to_Make_Array_Unique;

import org.junit.jupiter.api.Test;

import static matrix.workingPeoplesImitation.integer_helper.IntegerArrayHelper.readFromFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {1, 2, 2};
        int expected = 1;
        assertEquals(expected, testingClass.minIncrementForUnique(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {3, 2, 1, 2, 1, 7};
        int expected = 6;
        assertEquals(expected, testingClass.minIncrementForUnique(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = readFromFile("src/main/java/matrix/workingPeoplesImitation/task_945_Minimum_Increment_to_Make_Array_Unique/testcase03.txt", ",");
        int expected = 266671574;
        assertEquals(expected, testingClass.minIncrementForUnique(nums));
    }
}
