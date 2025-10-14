package matrix.workingPeoplesImitation.task_3349_Adjacent_Increasing_Subarrays_Detection_I;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        List<Integer> nums = List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
        int k = 3;
        assertTrue(testingClass.hasIncreasingSubarrays(nums, k));
    }

    @Test
    public void checkTestcase02() {
        List<Integer> nums = List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
        int k = 5;
        assertFalse(testingClass.hasIncreasingSubarrays(nums, k));
    }

    @Test
    public void checkTestcase03() {
        List<Integer> nums = List.of(19, 5);
        int k = 1;
        assertTrue(testingClass.hasIncreasingSubarrays(nums, k));
    }

    @Test
    public void checkTestcase04() {
        List<Integer> nums = List.of(-3, -19, -8, -16);
        int k = 2;
        assertFalse(testingClass.hasIncreasingSubarrays(nums, k));
    }

    @Test
    public void checkTestcase05() {
        List<Integer> nums = List.of(5, 8, -2, -1);
        int k = 2;
        assertTrue(testingClass.hasIncreasingSubarrays(nums, k));
    }
}
