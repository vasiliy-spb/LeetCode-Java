package matrix.workingPeoplesImitation.task_2376_Count_Special_Integers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int n = 20;
        int expected = 19;
        assertEquals(expected, testingClass.countSpecialNumbers(n));
    }

    @Test
    public void checkTestcase02() {
        int n = 5;
        int expected = 5;
        assertEquals(expected, testingClass.countSpecialNumbers(n));
    }

    @Test
    public void checkTestcase03() {
        int n = 135;
        int expected = 110;
        assertEquals(expected, testingClass.countSpecialNumbers(n));
    }

    @Test
    public void checkTestcase04() {
        int n = 2_000_000_000;
        int expected = 5974650;
        assertEquals(expected, testingClass.countSpecialNumbers(n));
    }
}
