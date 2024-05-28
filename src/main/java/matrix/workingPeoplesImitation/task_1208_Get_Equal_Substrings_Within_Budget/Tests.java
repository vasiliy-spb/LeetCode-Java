package matrix.workingPeoplesImitation.task_1208_Get_Equal_Substrings_Within_Budget;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int expected = 3;
        assertEquals(expected, testingClass.equalSubstring(s, t, maxCost));
    }

    @Test
    public void checkTestcase02() {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        int expected = 1;
        assertEquals(expected, testingClass.equalSubstring(s, t, maxCost));
    }

    @Test
    public void checkTestcase03() {
        String s = "abcd";
        String t = "acde";
        int maxCost = 0;
        int expected = 1;
        assertEquals(expected, testingClass.equalSubstring(s, t, maxCost));
    }

    @Test
    public void checkTestcase04() {
        String s = "anryddgaqpjdw";
        String t = "zjhotgdlmadcf";
        int maxCost = 5;
        int expected = 1;
        assertEquals(expected, testingClass.equalSubstring(s, t, maxCost));
    }

    @Test
    public void checkTestcase05() {
        String s = "krpgjbjjznpzdfy";
        String t = "nxargkbydxmsgby";
        int maxCost = 14;
        int expected = 4;
        assertEquals(expected, testingClass.equalSubstring(s, t, maxCost));
    }
}
