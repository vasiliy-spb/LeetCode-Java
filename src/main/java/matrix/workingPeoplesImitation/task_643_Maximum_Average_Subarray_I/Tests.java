package matrix.workingPeoplesImitation.task_643_Maximum_Average_Subarray_I;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double expected = 12.75;
        double precision = 1e-5;
        double result = testingClass.findMaxAverage(nums, k);
        assertEquals(expected, result, precision);
    }

    @Test
    public void makeTestcase2() {
        int[] nums = {5};
        int k = 1;
        double expected = 5.0;
        double precision = 1e-5;
        double result = testingClass.findMaxAverage(nums, k);
        assertEquals(expected, result, precision);
    }

    @Test
    public void makeTestcase3() {
        int[] nums = {5,7};
        int k = 2;
        double expected = 6.0;
        double precision = 1e-5;
        double result = testingClass.findMaxAverage(nums, k);
        assertEquals(expected, result, precision);
    }

    @Test
    public void makeTestcase4() { // 24 / 127 testcases passed
        int[] nums = {7,4,5,8,8,3,9,8,7,6};
        int k = 7;
        double expected = 7.0;
        double precision = 1e-5;
        double result = testingClass.findMaxAverage(nums, k);
        assertEquals(expected, result, precision);
    }

}
