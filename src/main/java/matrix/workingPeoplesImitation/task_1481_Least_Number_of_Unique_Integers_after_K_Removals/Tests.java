package matrix.workingPeoplesImitation.task_1481_Least_Number_of_Unique_Integers_after_K_Removals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] arr = {5, 5, 4};
        int k = 1;
        int expected = 1;
        assertEquals(expected, testingClass.findLeastNumOfUniqueInts(arr, k));
    }

    @Test
    public void checkTestcase2() {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        int expected = 2;
        assertEquals(expected, testingClass.findLeastNumOfUniqueInts(arr, k));
    }

    @Test
    public void checkTestcase3() {
        int[] arr = {2, 4, 1, 8, 3, 5, 1, 3};
        int k = 3;
        int expected = 3;
        assertEquals(expected, testingClass.findLeastNumOfUniqueInts(arr, k));
    }

}
