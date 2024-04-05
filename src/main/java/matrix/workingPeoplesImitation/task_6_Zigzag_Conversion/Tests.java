package matrix.workingPeoplesImitation.task_6_Zigzag_Conversion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        assertEquals(expected, testingClass.convert(s, numRows));
    }

    @Test
    public void checkTestcase2() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";
        assertEquals(expected, testingClass.convert(s, numRows));
    }

    @Test
    public void checkTestcase3() {
        String s = "A";
        int numRows = 1;
        String expected = "A";
        assertEquals(expected, testingClass.convert(s, numRows));
    }

    @Test
    public void checkTestcase4() { // 3 / 1157 testcases passed
        String s = "A";
        int numRows = 2;
        String expected = "A";
        assertEquals(expected, testingClass.convert(s, numRows));
    }

    @Test
    public void checkTestcase5() { // 7 / 1157 testcases passed
        String s = "AB";
        int numRows = 1;
        String expected = "AB";
        assertEquals(expected, testingClass.convert(s, numRows));
    }
}
