package matrix.workingPeoplesImitation.task_14_Longest_Common_Prefix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] strs = {"flower", "flow", "flight"};
        String expected = "fl";
        assertEquals(expected, testingClass.longestCommonPrefix(strs));
    }

    @Test
    public void checkTestcase02() {
        String[] strs = {"dog","racecar","car"};
        String expected = "";
        assertEquals(expected, testingClass.longestCommonPrefix(strs));
    }

    @Test
    public void checkTestcase03() {
        String[] strs = {""};
        String expected = "";
        assertEquals(expected, testingClass.longestCommonPrefix(strs));
    }

    @Test
    public void checkTestcase04() {
        String[] strs = {"a"};
        String expected = "a";
        assertEquals(expected, testingClass.longestCommonPrefix(strs));
    }
}
