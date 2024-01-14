package matrix.workingPeoplesImitation.task_1657_Determine_if_Two_Strings_Are_Close;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void testCloseStringsExample1() {
        String word1 = "abc";
        String word2 = "bca";
        assertTrue(testingClass.closeStrings(word1, word2));
    }

    @Test
    public void testCloseStringsExample2() {
        String word1 = "a";
        String word2 = "aa";
        assertFalse(testingClass.closeStrings(word1, word2));
    }

    @Test
    public void testCloseStringsExample3() {
        String word1 = "cabbba";
        String word2 = "abbccc";
        assertTrue(testingClass.closeStrings(word1, word2));
    }

    @Test
    public void testCloseStringsAdditional1() {
        String word1 = "abcde";
        String word2 = "aecdb";
        assertTrue(testingClass.closeStrings(word1, word2));
    }

    @Test
    public void testCloseStringsAdditional2() {
        String word1 = "aab";
        String word2 = "bba";
        assertTrue(testingClass.closeStrings(word1, word2));
    }

    @Test
    public void testCloseStringsAdditional3() {
        String word1 = "xyz";
        String word2 = "abc";
        assertFalse(testingClass.closeStrings(word1, word2));
    }
}
