package matrix.workingPeoplesImitation.task_214_Shortest_Palindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "aacecaaa";
        String expected = "aaacecaaa";
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "abcd";
        String expected = "dcbabcd";
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "aaceecaaa";
        String expected = "aaaceecaaa";
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }

    @Test
    public void checkTestcase04() {
        String s = "abcd";
        String expected = "dcbabcd";
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }

    @Test
    public void checkTestcase05() {
        String s = "";
        String expected = "";
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }

    @Test
    public void checkTestcase06() {
        String s = "aaaaa";
        String expected = "aaaaa";
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }

    @Test
    public void checkTestcase07() {
        String s = "a".repeat(20000) + "cd" + "a".repeat(20000);
        String expected = "a".repeat(20000) + "dc" + "a".repeat(20000) + "cd" + "a".repeat(20000);
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }

    @Test
    public void checkTestcase08() {
        String s = "ab".repeat(25000);
        String expected = "b" + "ab".repeat(25000);
        assertEquals(expected, testingClass.shortestPalindrome(s));
    }
}
