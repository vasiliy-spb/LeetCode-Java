package matrix.workingPeoplesImitation.task_2531_Make_Number_of_Distinct_Characters_Equal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String word1 = "ac";
        String word2 = "b";
        assertFalse(testingClass.isItPossible(word1, word2));
    }

    @Test
    public void checkTestcase02() {
        String word1 = "abcc";
        String word2 = "aab";
        assertTrue(testingClass.isItPossible(word1, word2));
    }

    @Test
    public void checkTestcase03() {
        String word1 = "abcde";
        String word2 = "fghij";
        assertTrue(testingClass.isItPossible(word1, word2));
    }

    @Test
    public void checkTestcase04() {
        String word1 = "ab";
        String word2 = "abcc";
        assertFalse(testingClass.isItPossible(word1, word2));
    }

    @Test
    public void checkTestcase05() {
        String word1 = "aa";
        String word2 = "ab";
        assertFalse(testingClass.isItPossible(word1, word2));
    }
}
