package matrix.workingPeoplesImitation.task_3507_Minimum_Pair_Removal_to_Sort_Array_I;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTests {
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        int[] nums = {5, 2, 3, 1};
        int expected = 2;
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {1, 2, 2};
        int expected = 0;
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1};
        int expected = 9;
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {3,6,4,-6,2,-4,5,-7,-3,6,3,-4};
        int expected = 10;
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkAlreadySorted() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 0;
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkSingleElement() {
        int[] nums = {5};
        int expected = 0;
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkNegativeNumbers() {
        int[] nums = {-5, -3, -2, -4};
        int expected = 2;
        // [-5, -3, -2, -4] -> [-5, -3, -6] -> [-5, -9]
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkAllEqual() {
        int[] nums = {3, 3, 3, 3};
        int expected = 0;
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }

    @Test
    public void checkSimpleDecreasing() {
        int[] nums = {4, 3, 2, 1};
        int expected = 2;
        // [4,3,2,1] -> [4,3,3] -> [4,6]
        assertEquals(expected, testingClass.minimumPairRemoval(nums));
    }
}
