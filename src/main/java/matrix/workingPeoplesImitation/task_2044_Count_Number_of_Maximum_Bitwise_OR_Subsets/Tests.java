package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
//    private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();
//    private final Solution3 testingClass = new Solution3();
//    private final Solution4 testingClass = new Solution4();
    private final Solution5 testingClass = new Solution5();

    @Test
    public void checkTestcase01() {
        int[] nums = {3, 1};
        int expected = 2;
        assertEquals(expected, testingClass.countMaxOrSubsets(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {2, 2, 2};
        int expected = 7;
        assertEquals(expected, testingClass.countMaxOrSubsets(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {3, 2, 1, 5};
        int expected = 6;
        assertEquals(expected, testingClass.countMaxOrSubsets(nums));
    }
}
