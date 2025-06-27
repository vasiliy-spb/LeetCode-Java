package matrix.workingPeoplesImitation.task_2311_Longest_Binary_Subsequence_Less_Than_or_Equal_to_K;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "1001010";
        int k = 5;
        int expected = 5;
        assertEquals(expected, testingClass.longestSubsequence(s, k));
    }

    @Test
    public void checkTestcase02() {
        String s = "00101001";
        int k = 1;
        int expected = 6;
        assertEquals(expected, testingClass.longestSubsequence(s, k));
    }

    @Test
    public void checkTestcase03() {
        String s = "0";
        int k = 583196182;
        int expected = 1;
        assertEquals(expected, testingClass.longestSubsequence(s, k));
    }

    @Test
    public void checkTestcase04() {
        String s = "001010101011010100010101101010010";
        int k = 93951055;
        int expected = 31;
        assertEquals(expected, testingClass.longestSubsequence(s, k));
    }
}
