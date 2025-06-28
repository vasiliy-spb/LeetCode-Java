package matrix.workingPeoplesImitation.task_3291_Minimum_Number_of_Valid_Strings_to_Form_Target_I;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] words = {"abc", "aaaaa", "bcdef"};
        String target = "aabcdabc";
        int expected = 3;
        assertEquals(expected, testingClass.minValidStrings(words, target));
    }

    @Test
    public void checkTestcase02() {
        String[] words = {"abababab", "ab"};
        String target = "ababaababa";
        int expected = 2;
        assertEquals(expected, testingClass.minValidStrings(words, target));

    }

    @Test
    public void checkTestcase03() {
        String[] words = {"abcdef"};
        String target = "xyz";
        int expected = -1;
        assertEquals(expected, testingClass.minValidStrings(words, target));
    }

    @Test
    public void checkTestcase04() {
        String[] words = {"b", "ccacc", "a"};
        String target = "cccaaaacba";
        int expected = 8;
        assertEquals(expected, testingClass.minValidStrings(words, target));
    }

    @Test
    public void checkTestcase05() {
        String[] words = {"cba","bcbc","ba"};
        String target = "ccccbaccba";
        int expected = 6;
        assertEquals(expected, testingClass.minValidStrings(words, target));
    }
}
