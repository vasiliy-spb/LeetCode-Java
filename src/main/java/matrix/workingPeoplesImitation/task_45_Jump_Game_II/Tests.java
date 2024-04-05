package matrix.workingPeoplesImitation.task_45_Jump_Game_II;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        int result = testingClass.jump(nums);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {2, 3, 0, 1, 4};
        int expected = 2;
        int result = testingClass.jump(nums);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase3() { // 15 / 109 testcases passed
        int[] nums = {1, 2};
        int expected = 1;
        int result = testingClass.jump(nums);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase4() { // 107 / 109 testcases passed
        int[] nums = {0};
        int expected = 0;
        int result = testingClass.jump(nums);
        assertEquals(expected, result);
    }

//    @Test
//    public void checkTestcase5() { // 150 / 172 testcases passed
//        int[] nums = {1, 1, 2, 2, 0, 1, 1};
//        int result = testingClass.jump(nums);
//    }
//
//    @Test
//    public void checkTestcase6() { // 171 / 172 testcases passed
//        int[] nums = {4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0};
//        int result = testingClass.jump(nums);
//    }
//
//    @Test
//    public void checkTestcase7() { // 168 / 172 testcases passed
//        int[] nums = {3, 0, 8, 2, 0, 0, 1};
//        int result = testingClass.jump(nums);
//    }
//
//    @Test
//    public void checkTestcase8() { // 170 / 172 testcases passed
//        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
//        int result = testingClass.jump(nums);
//    }
}
