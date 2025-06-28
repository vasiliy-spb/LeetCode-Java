package matrix.workingPeoplesImitation.task_438_Find_All_Anagrams_in_a_String;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> expected = List.of(0, 6);
        assertEquals(expected, testingClass.findAnagrams(s, p));
    }

    @Test
    public void checkTestcase02() {
        String s = "abab";
        String p = "ab";
        List<Integer> expected = List.of(0, 1, 2);
        assertEquals(expected, testingClass.findAnagrams(s, p));
    }

    @Test
    public void checkTestcase03() {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        List<Integer> expected = List.of();
        assertEquals(expected, testingClass.findAnagrams(s, p));
    }

    @Test
    public void checkTestcase04() {
        String s = "a".repeat(10000) +
                'b' +
                "a".repeat(10000);
        String p = "a".repeat(10000);
        List<Integer> expected = List.of(0,10001);
        assertEquals(expected, testingClass.findAnagrams(s, p));
    }
}
