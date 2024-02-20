package matrix.workingPeoplesImitation.task_334_Increasing_Triplet_Subsequence;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {

    private final Solution testingClass = new Solution();

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 3, 4, 5};
        assertTrue(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {5, 4, 3, 2, 1};
        assertFalse(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = {2, 1, 5, 0, 4, 6};
        assertTrue(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testExample4() {
        int[] nums = {20, 100, 10, 12, 5, 13};
        assertTrue(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testExample5() {
        int[] nums = {8, 7, 9, 6, 5, 7, 3, 2, 4};
        assertFalse(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testExample6() {
        int[] nums = {5, 1, 5, 5, 2, 5, 4};
        assertTrue(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        assertFalse(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testSingleElementArray() {
        int[] nums = {5};
        assertFalse(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testDuplicateElements() {
        int[] nums = {1, 2, 2, 3, 4};
        assertTrue(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testDescendingOrder() {
        int[] nums = {5, 4, 3, 2, 1, 0};
        assertFalse(testingClass.increasingTriplet(nums));
    }

    @Test
    public void testIncreasingTripletAtEnd() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
        assertTrue(testingClass.increasingTriplet(nums));
    }
}
