package matrix.workingPeoplesImitation.task_2971_Find_Polygon_With_the_Largest_Perimeter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {5, 5, 5};
        int expected = 15;
        assertEquals(expected, testingClass.largestPerimeter(nums));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        int expected = 12;
        assertEquals(expected, testingClass.largestPerimeter(nums));
    }

    @Test
    public void checkTestcase3() {
        int[] nums = {5, 5, 50};
        int expected = -1;
        assertEquals(expected, testingClass.largestPerimeter(nums));
    }

    @Test
    public void checkTestcase4() { // 731 / 980 testcases passed
        int[] nums = {1, 5, 1, 5};
        int expected = 12;
        assertEquals(expected, testingClass.largestPerimeter(nums));
    }

    @Test
    public void checkTestcase5() { // 918 / 980 testcases passed
        int[] nums = {300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987};
        long expected = 17876942274l;
        assertEquals(expected, testingClass.largestPerimeter(nums));
    }

}
