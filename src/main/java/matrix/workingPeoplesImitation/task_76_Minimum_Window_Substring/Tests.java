package matrix.workingPeoplesImitation.task_76_Minimum_Window_Substring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        assertEquals(expected, testingClass.minWindow(s, t));
    }

    @Test
    public void checkTestcase2() {
        String s = "a";
        String t = "a";
        String expected = "a";
        assertEquals(expected, testingClass.minWindow(s, t));
    }

    @Test
    public void checkTestcase3() {
        String s = "a";
        String t = "aa";
        String expected = "";
        assertEquals(expected, testingClass.minWindow(s, t));
    }

    @Test
    public void checkTestcase4() {
        String s = "";
        String t = "";
        String expected = "";
        assertEquals(expected, testingClass.minWindow(s, t));
    }

    @Test
    public void checkTestcase5() { // 3 / 267 testcases passed
        String s = "a";
        String t = "b";
        String expected = "";
        assertEquals(expected, testingClass.minWindow(s, t));
    }

    @Test
    public void checkTestcase6() { // 222 / 267 testcases passed
        String s = "acbdbaab";
        String t = "aabd";
        String expected = "dbaa";
        assertEquals(expected, testingClass.minWindow(s, t));
    }

}
