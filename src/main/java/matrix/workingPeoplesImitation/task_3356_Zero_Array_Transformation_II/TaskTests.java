package matrix.workingPeoplesImitation.task_3356_Zero_Array_Transformation_II;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void testExample1() {
        int[] nums = {2, 0, 2};
        int[][] queries = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};
        int expected = 2;
        assertEquals(expected, testingClass.minZeroArray(nums, queries));
    }

    @Test
    public void testExample2() {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3, 2}, {0, 2, 1}};
        int expected = -1;
        assertEquals(expected, testingClass.minZeroArray(nums, queries));
    }

    @Test
    public void testExample3() {
        int[] nums = {0};
        int[][] queries = {{0, 0, 2}, {0, 0, 4}, {0, 0, 4}, {0, 0, 3}, {0, 0, 5}};
        int expected = 0;
        assertEquals(expected, testingClass.minZeroArray(nums, queries));
    }
}
