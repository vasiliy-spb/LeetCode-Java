package matrix.workingPeoplesImitation.task_724_Find_Pivot_Index;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] nums = {1,7,3,6,5,6};
        int expected = 3;
        assertEquals(expected, testingClass.pivotIndex(nums));
    }

    @Test
    public void makeTestcase2() {
        int[] nums = {1,2,3};
        int expected = -1;
        assertEquals(expected, testingClass.pivotIndex(nums));
    }

    @Test
    public void makeTestcase3() {
        int[] nums = {2,1,-1};
        int expected = 0;
        assertEquals(expected, testingClass.pivotIndex(nums));
    }

    @Test
    public void makeTestcase4() {
        int[] nums = {2,-2,1,-1,1};
        int expected = 2;
        assertEquals(expected, testingClass.pivotIndex(nums));
    }

    @Test
    public void makeTestcase5() { // 286 / 746 testcases passed
        int[] nums = {-1,-1,-1,-1,-1,-1};
        int expected = -1;
        assertEquals(expected, testingClass.pivotIndex(nums));
    }

}
