package matrix.workingPeoplesImitation.task_8_String_to_Integer_atoi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "42";
        int expected = 42;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase2() {
        String s = "   -42";
        int expected = -42;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase3() {
        String s = "4193 with words";
        int expected = 4193;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase4() {
        String s = "words and 987";
        int expected = 0;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase5() {
        String s = "-91283472332";
        int expected = -2147483648;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase6() {
        String s = "+1";
        int expected = 1;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase7() {
        String s = "+-12";
        int expected = 0;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase8() {
        String s = "20000000000000000000";
        int expected = 2147483647;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase9() {
        String s = "  0000000000012345678";
        int expected = 12345678;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase10() {
        String s = "21474836460";
        int expected = 2147483647;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase11() {
        String s = "-000000000000001";
        int expected = -1;
        assertEquals(expected, testingClass.myAtoi(s));
    }

    @Test
    public void checkTestcase12() {
        String s = "00000-42a1234";
        int expected = 0;
        assertEquals(expected, testingClass.myAtoi(s));
    }

}
