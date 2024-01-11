package matrix.workingPeoplesImitation.task_1768_Merge_Strings_Alternately;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private final Solution2 testingClass = new Solution2();

    @Test
    public void makeTestcase1() {
        String word1 = "abc";
        String word2 = "pqr";
        String expected = "apbqcr";
        assertEquals(expected, testingClass.mergeAlternately(word1, word2));
    }

    @Test
    public void makeTestcase2() {
        String word1 = "ab";
        String word2 = "pqrs";
        String expected = "apbqrs";
        assertEquals(expected, testingClass.mergeAlternately(word1, word2));
    }

    @Test
    public void makeTestcase3() {
        String word1 = "abcd";
        String word2 = "pq";
        String expected = "apbqcd";
        assertEquals(expected, testingClass.mergeAlternately(word1, word2));
    }

    @Test
    public void makeTestcaseEmptyString() {
        String word1 = "";
        String word2 = "";
        String expected = "";
        assertEquals(expected, testingClass.mergeAlternately(word1, word2));
    }

}
