package matrix.workingPeoplesImitation.task_264_Ugly_Number_II;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int n = 10;
        int expected = 12;
        assertEquals(expected, testingClass.nthUglyNumber(n));
    }

    @Test
    public void checkTestcase2() {
        int n = 1;
        int expected = 1;
        assertEquals(expected, testingClass.nthUglyNumber(n));
    }

    @Test
    public void checkTestcase3() {
        int n = 1690;
        int expected = 2123366400;
        assertEquals(expected, testingClass.nthUglyNumber(n));
    }

}
