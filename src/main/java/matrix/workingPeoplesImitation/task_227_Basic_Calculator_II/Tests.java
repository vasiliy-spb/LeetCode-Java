package matrix.workingPeoplesImitation.task_227_Basic_Calculator_II;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "3+2*2";
        int expected = 7;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase02() {
        String s = " 3/2 ";
        int expected = 1;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase03() {
        String s = " 3+5 / 2 ";
        int expected = 5;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase04() { // 73 / 111 testcases passed
        String s = "2*3-4";
        int expected = 2;
        assertEquals(expected, testingClass.calculate(s));
    }
}
