package matrix.workingPeoplesImitation.task_2486_Append_Characters_to_String_to_Make_Subsequence;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "coaching";
        String t = "coding";
        int expected = 4;
        assertEquals(expected, testingClass.appendCharacters(s, t));
    }

    @Test
    public void checkTestcase02() {
        String s = "abcde";
        String t = "a";
        int expected = 0;
        assertEquals(expected, testingClass.appendCharacters(s, t));
    }

    @Test
    public void checkTestcase03() {
        String s = "z";
        String t = "abcde";
        int expected = 5;
        assertEquals(expected, testingClass.appendCharacters(s, t));
    }

    @Test
    public void checkTestcase04() {
        String s = "vrykt";
        String t = "rkge";
        int expected = 2;
        assertEquals(expected, testingClass.appendCharacters(s, t));
    }

    @Test
    public void checkTestcase05() {
        try {
            String s = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_2486_Append_Characters_to_String_to_Make_Subsequence/testcase5_s.txt")).readLine();
            String t = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_2486_Append_Characters_to_String_to_Make_Subsequence/testcase5_t.txt")).readLine();
            int expected = 96063;
            assertEquals(expected, testingClass.appendCharacters(s, t));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
