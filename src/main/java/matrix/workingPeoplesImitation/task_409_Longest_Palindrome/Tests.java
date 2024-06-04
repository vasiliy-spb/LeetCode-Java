package matrix.workingPeoplesImitation.task_409_Longest_Palindrome;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "abccccdd";
        int expected = 7;
        assertEquals(expected, testingClass.longestPalindrome(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "a";
        int expected = 1;
        assertEquals(expected, testingClass.longestPalindrome(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "AAAAAA";
        int expected = 6;
        assertEquals(expected, testingClass.longestPalindrome(s));
    }

    @Test
    public void checkTestcase04() {
        try {
            String s = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_409_Longest_Palindrome/testcase4.txt")).readLine();
            int expected = 983;
            assertEquals(expected, testingClass.longestPalindrome(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkTestcase05() {
        String s = "abccccdd";
        int expected = 7;
        assertEquals(expected, testingClass.longestPalindrome(s));
    }
}
