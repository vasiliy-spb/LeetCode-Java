package matrix.workingPeoplesImitation.task_224_Basic_Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "1 + 1";
        int expected = 2;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase2() {
        String s = " 2-1 + 2 ";
        int expected = 3;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase3() {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int expected = 23;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase4() {
        String s = "- 2-1 + 2 ";
        int expected = -1;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase5() {
        String s = "-(1+(4+5+2)-3)+(6+8)";
        int expected = 5;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase6() { // 11 / 45 testcases passed
        String s = "1-(     -2)";
        int expected = 3;
        assertEquals(expected, testingClass.calculate(s));
    }

    @Test
    public void checkTestcase7() { // 13 / 45 testcases passed
        String s = "- (3 + (4 + 5))";
        int expected = -12;
        assertEquals(expected, testingClass.calculate(s));
    }

}
