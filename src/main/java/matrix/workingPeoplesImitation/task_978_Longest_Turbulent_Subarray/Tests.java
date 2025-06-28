package matrix.workingPeoplesImitation.task_978_Longest_Turbulent_Subarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int expected = 5;
        assertEquals(expected, testingClass.maxTurbulenceSize(arr));
    }

    @Test
    public void checkTestcase2() {
        int[] arr = {4, 8, 12, 16};
        int expected = 2;
        assertEquals(expected, testingClass.maxTurbulenceSize(arr));
    }

    @Test
    public void checkTestcase3() {
        int[] arr = {100};
        int expected = 1;
        assertEquals(expected, testingClass.maxTurbulenceSize(arr));
    }

    @Test
    public void checkTestcase4() {
        int[] arr = {9, 9};
        int expected = 1;
        assertEquals(expected, testingClass.maxTurbulenceSize(arr));
    }

    @Test
    public void checkTestcase5() {
        int[] arr = {2, 0, 2, 4, 2, 5, 0, 1, 2, 3};
        int expected = 6;
        assertEquals(expected, testingClass.maxTurbulenceSize(arr));
    }
}
