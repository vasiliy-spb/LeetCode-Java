package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "aaaa";
        int expected = 2;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "abcdef";
        int expected = -1;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "abcaba";
        int expected = 1;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase04() {
        String s = "a".repeat(100000);
        int expected = 99998;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase05() {
        String s = "aada";
        int expected = 1;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase06() {
        String s = "ereerrrererrrererre";
        int expected = 2;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase07() {
        String s = "dceeddedcedcdcdedcdddeeedddsssdcdcdeeeccdccedeeedd";
        int expected = 3;
        assertEquals(expected, testingClass.maximumLength(s));
    }
}
