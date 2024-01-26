package matrix.workingPeoplesImitation.task_1143_Longest_Common_Subsequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String input1 = "abcde";
        String input2 = "ace";
        int expected = 3;
        assertEquals(expected, testingClass.longestCommonSubsequence(input1, input2));
    }

    @Test
    public void checkTestcase2() {
        String input1 = "abc";
        String input2 = "abc";
        int expected = 3;
        assertEquals(expected, testingClass.longestCommonSubsequence(input1, input2));
    }

    @Test
    public void checkTestcase3() {
        String input1 = "abc";
        String input2 = "def";
        int expected = 0;
        assertEquals(expected, testingClass.longestCommonSubsequence(input1, input2));
    }

    @Test
    public void checkTestcase4() {
        String input1 = "abcde";
        String input2 = "atcue";
        int expected = 3;
        assertEquals(expected, testingClass.longestCommonSubsequence(input1, input2));
    }

    @Test
    public void checkTestcase5() { // 8 / 47 testcases passed
        String input1 = "psnw";
        String input2 = "vozsh";
        int expected = 1;
        assertEquals(expected, testingClass.longestCommonSubsequence(input1, input2));
    }

    @Test
    public void checkTestcase6() { // 16 / 47 testcases passed
        String input1 = "bsbininm";
        String input2 = "jmjkbkjkv";
        int expected = 1;
        assertEquals(expected, testingClass.longestCommonSubsequence(input1, input2));
    }

}
