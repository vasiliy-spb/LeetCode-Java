package matrix.workingPeoplesImitation.task_3_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        String input = "abcabcbb";
        int expected = 3;
        assertEquals(expected, testingClass.lengthOfLongestSubstring(input));
    }

    @Test
    public void makeTestcase2() {
        String input = "bbbbb";
        int expected = 1;
        assertEquals(expected, testingClass.lengthOfLongestSubstring(input));
    }

    @Test
    public void makeTestcase3() {
        String input = "pwwkew";
        int expected = 3;
        assertEquals(expected, testingClass.lengthOfLongestSubstring(input));
    }

    @Test
    public void makeTestcase4() { // 284 / 987 testcases passed
        String input = "aab";
        int expected = 2;
        assertEquals(expected, testingClass.lengthOfLongestSubstring(input));
    }

    @Test
    public void makeTestcaseEmptyString() {
        String input = "";
        int expected = 0;
        assertEquals(expected, testingClass.lengthOfLongestSubstring(input));
    }

}
