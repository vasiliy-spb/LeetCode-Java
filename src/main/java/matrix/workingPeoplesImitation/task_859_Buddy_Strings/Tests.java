package matrix.workingPeoplesImitation.task_859_Buddy_Strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "ab";
        String goal = "ba";
        assertTrue(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase02() {
        String s = "ab";
        String goal = "ab";
        assertFalse(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase03() {
        String s = "aa";
        String goal = "aa";
        assertTrue(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase04() {
        String s = "abcd";
        String goal = "abcf";
        assertFalse(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase05() {
        String s = "abcd";
        String goal = "abcd";
        assertFalse(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase06() {
        String s = "abcaa";
        String goal = "abcbb";
        assertFalse(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase07() {
        String s = "abcd";
        String goal = "badc";
        assertFalse(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase08() {
        String s = "ab";
        String goal = "ca";
        assertFalse(testingClass.buddyStrings(s, goal));
    }

    @Test
    public void checkTestcase09() {
        String s = "abab";
        String goal = "baba";
        assertFalse(testingClass.buddyStrings(s, goal));
    }
}
