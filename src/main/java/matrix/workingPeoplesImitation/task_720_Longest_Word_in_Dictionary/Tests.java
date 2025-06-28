package matrix.workingPeoplesImitation.task_720_Longest_Word_in_Dictionary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        String expected = "world";
        assertEquals(expected, testingClass.longestWord(words));
    }

    @Test
    public void checkTestcase02() {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String expected = "apple";
        assertEquals(expected, testingClass.longestWord(words));
    }

    @Test
    public void checkTestcase03() {
        String[] words = {"a", "d", "b", "s", "da", "c", "bs"};
        String expected = "bs";
        assertEquals(expected, testingClass.longestWord(words));
    }

    @Test
    public void checkTestcase04() {
        String[] words = {"n", "j", "sl", "yyd", "slo", "jk", "jkdt", "y", "yy"};
        String expected = "yyd";
        assertEquals(expected, testingClass.longestWord(words));
    }
}
