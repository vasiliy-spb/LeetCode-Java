package matrix.workingPeoplesImitation.task_283_Move_Zeroes;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {

    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int [] nums = {0,1,0,3,12};
        testingClass.moveZeroes(nums);
        int [] outputNums = {1,3,12,0,0};
        assertArrayEquals(outputNums, nums);
    }

    @Test
    public void makeTestcase2() {
        int [] nums = {0};
        testingClass.moveZeroes(nums);
        int [] outputNums = {0};
        assertArrayEquals(outputNums, nums);
    }

    @Test
    public void makeTestcase3() {
        int [] nums = {1};
        testingClass.moveZeroes(nums);
        int [] outputNums = {1};
        assertArrayEquals(outputNums, nums);
    }

    @Test
    public void makeTestcase4() {
        int [] nums = {1,0};
        testingClass.moveZeroes(nums);
        int [] outputNums = {1,0};
        assertArrayEquals(outputNums, nums);
    }

}
