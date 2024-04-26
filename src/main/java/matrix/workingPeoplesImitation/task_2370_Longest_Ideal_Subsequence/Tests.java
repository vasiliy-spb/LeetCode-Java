package matrix.workingPeoplesImitation.task_2370_Longest_Ideal_Subsequence;

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
        String s = "acfgbd";
        int k = 2;
        int expected = 4;
        assertEquals(expected, testingClass.longestIdealString(s, k));
    }

    @Test
    public void checkTestcase02() {
        String s = "abcd";
        int k = 3;
        int expected = 4;
        assertEquals(expected, testingClass.longestIdealString(s, k));
    }

    @Test
    public void checkTestcase03() {
        String s = "acbdefghijklmnopqrstuvwxyz";
        int k = 2;
        int expected = 26;
        assertEquals(expected, testingClass.longestIdealString(s, k));
    }

    @Test
    public void checkTestcase04() { // 32 / 85 testcases passed
        String s = "eduktdb";
        int k = 15;
        int expected = 5;
        assertEquals(expected, testingClass.longestIdealString(s, k));
    }

    @Test
    public void checkTestcase05() { // 75 / 85 testcases passed
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_2370_Longest_Ideal_Subsequence/testcase05"))) {
            String s = reader.readLine();
            int k = 7;
            int expected = 41307;
            assertEquals(expected, testingClass.longestIdealString(s, k));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
