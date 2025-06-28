package matrix.workingPeoplesImitation.task_1392_Longest_Happy_Prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "level";
        String expected = "l";
        assertEquals(expected, testingClass.longestPrefix(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "ababab";
        String expected = "abab";
        assertEquals(expected, testingClass.longestPrefix(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "eeeeee";
        String expected = "eeeee";
        assertEquals(expected, testingClass.longestPrefix(s));
    }

    @Test
    public void checkTestcase04() {
        String s = "t";
        String expected = "";
        assertEquals(expected, testingClass.longestPrefix(s));
    }

    @Test
    public void checkTestcase05() {
        String s = "od";
        String expected = "";
        assertEquals(expected, testingClass.longestPrefix(s));
    }

    @Test
    public void checkTestcase06() {
        String s = "dd";
        String expected = "d";
        assertEquals(expected, testingClass.longestPrefix(s));
    }
}
