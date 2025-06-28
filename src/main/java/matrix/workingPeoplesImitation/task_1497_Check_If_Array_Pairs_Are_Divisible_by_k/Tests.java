package matrix.workingPeoplesImitation.task_1497_Check_If_Array_Pairs_Are_Divisible_by_k;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        assertTrue(testingClass.canArrange(arr, k));
    }

    @Test
    public void checkTestcase02() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 7;
        assertTrue(testingClass.canArrange(arr, k));
    }

    @Test
    public void checkTestcase03() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 10;
        assertFalse(testingClass.canArrange(arr, k));
    }

    @Test
    public void checkTestcase04() {
        int[] arr = {-1, 1, -2, 2, -3, 3, -4, 4};
        int k = 3;
        assertTrue(testingClass.canArrange(arr, k));
    }

    @Test
    public void checkTestcase05() {
        int[] arr = {0, 0};
        int k = 3;
        assertTrue(testingClass.canArrange(arr, k));
    }

    @Test
    public void checkTestcase06() {
        int[] arr = {-1, -2};
        int k = 3;
        assertTrue(testingClass.canArrange(arr, k));
    }

    @Test
    public void checkTestcase07() {
        int[] arr = {-4, -7, 5, 2, 9, 1, 10, 4, -8, -3};
        int k = 3;
        assertTrue(testingClass.canArrange(arr, k));
        /*
       {-4, -7, 5, 2, 9, 1, 10, 4, -8, -3}

        10 5
        -3 9
        -4 1
        2 4
        -7 -8

        1 2
        0 0
        -1 1
        2 1
        -1 -2

         */
    }
}
