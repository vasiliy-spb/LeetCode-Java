package matrix.workingPeoplesImitation.task_2165_Smallest_Value_of_Rearranged_Number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        long num = 310;
        long expected = 103;
        assertEquals(expected, testingClass.smallestNumber(num));
    }

    @Test
    public void checkTestcase02() {
        long num = -7605;
        long expected = -7650;
        assertEquals(expected, testingClass.smallestNumber(num));
    }

    @Test
    public void checkTestcase03() {
        long num = 54321;
        long expected = 12345;
        assertEquals(expected, testingClass.smallestNumber(num));
    }

    @Test
    public void checkTestcase04() {
        long num = 0;
        long expected = 0;
        assertEquals(expected, testingClass.smallestNumber(num));
    }

    @Test
    public void checkTestcase05() {
        long num = 2170596702L;
        long expected = 1002256779;
        assertEquals(expected, testingClass.smallestNumber(num));
    }

    @Test
    public void checkTestcase06() {
        long num = 100001000;
        long expected = 100000001;
        assertEquals(expected, testingClass.smallestNumber(num));
    }
}
