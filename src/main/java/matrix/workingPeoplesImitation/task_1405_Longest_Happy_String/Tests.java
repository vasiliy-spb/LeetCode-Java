package matrix.workingPeoplesImitation.task_1405_Longest_Happy_String;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
//    private final Solution testingClass = new Solution();
    private final Solution4 testingClass = new Solution4();

    @Test
    public void checkTestcase01() {
        int a = 1;
        int b = 1;
        int c = 7;
        String expected = "ccaccbcc";
        String result = testingClass.longestDiverseString(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase02() {
        int a = 7;
        int b = 1;
        int c = 0;
        String expected = "aabaa";
        String result = testingClass.longestDiverseString(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase03() {
        int a = 0;
        int b = 8;
        int c = 11;
//        String expected = "ccbccbbccbbccbbccbc";
//        String expected = "cbcbcbcbcbcbcbccbcc";
        Set<String> expected = Set.of("ccbccbbccbbccbbccbc", "cbcbcbcbcbcbcbccbcc");
        String result = testingClass.longestDiverseString(a, b, c);
        assertTrue(expected.contains(result));
    }

    @Test
    public void checkTestcase04() {
        int a = 4;
        int b = 42;
        int c = 7;
//        String expected = "bbcbbcbbcbbabbcbbabbcbbabbcbbabbcbb";
        Set<String> expected = Set.of("bbcbbcbbcbbabbcbbabbcbbabbcbbabbcbb", "bbcbbcbbcbbcbbcbbcbbcbbabbabbabbabb");
        String result = testingClass.longestDiverseString(a, b, c);
        assertTrue(expected.contains(result));
    }

    @Test
    public void checkTestcase05() {
        int a = 12;
        int b = 45;
        int c = 0;
        String expected = "bbabbabbabbabbabbabbabbabbabbabbabbabb";
        String result = testingClass.longestDiverseString(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase06() {
        int a = 99;
        int b = 98;
        int c = 100;
        String expected = "caabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcc";
        String result = testingClass.longestDiverseString(a, b, c);
//        assertEquals(expected, result);
        System.out.println("result = " + result);
        assertEquals(297, result.length());
    }

    @Test
    public void checkTestcase07() {
        int a = 4;
        int b = 4;
        int c = 3;
//        String expected = "aabbccaabbc";
        Set<String> expected = Set.of("aabbccaabbc", "abbcabbcaac");
        String result = testingClass.longestDiverseString(a, b, c);
        assertTrue(expected.contains(result));
    }

    // Это мой тест, моё решение даёт на него неправильный ответ, но проходит все тесты в leetcode
    @Test
    public void checkTestcase08() {
        int a = 12;
        int b = 45;
        int c = 100;
        Set<String> expected = Set.of("ccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccbccaccbccaccbccaccbccaccbccaccbccaccbccaccbbccaabbccaabbcca");
        String result = testingClass.longestDiverseString(a, b, c);
        System.out.println("result = " + result);
        assertTrue(expected.contains(result));
    }
}
