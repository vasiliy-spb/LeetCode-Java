package matrix.workingPeoplesImitation.task_1207_Unique_Number_of_Occurrences;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] arr = {1, 2, 2, 1, 1, 3};
        assertTrue(testingClass.uniqueOccurrences(arr));
    }

    @Test
    public void checkTestcase2() {
        int[] arr = {1, 2};
        assertFalse(testingClass.uniqueOccurrences(arr));
    }

    @Test
    public void checkTestcase3() {
        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        assertTrue(testingClass.uniqueOccurrences(arr));
    }

}
