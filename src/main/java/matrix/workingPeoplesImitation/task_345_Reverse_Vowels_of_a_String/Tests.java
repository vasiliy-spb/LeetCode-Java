package matrix.workingPeoplesImitation.task_345_Reverse_Vowels_of_a_String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "hello";
        String expected = "holle";
        assertEquals(expected, testingClass.reverseVowels(s));
    }

    @Test
    public void checkTestcase2() {
        String s = "leetcode";
        String expected = "leotcede";
        assertEquals(expected, testingClass.reverseVowels(s));
    }

    @Test
    public void checkTestcase3() { // 10 / 480 testcases passed
        String s = ".,";
        String expected = ".,";
        assertEquals(expected, testingClass.reverseVowels(s));
    }
}
