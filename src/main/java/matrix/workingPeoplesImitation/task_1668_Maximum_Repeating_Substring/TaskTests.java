package matrix.workingPeoplesImitation.task_1668_Maximum_Repeating_Substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution4 testingClass = new Solution4();

    @Test
    public void checkTestcase01() {
        String sequence = "ababc";
        String word = "ab";
        int expected = 2;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }

    @Test
    public void checkTestcase02() {
        String sequence = "ababc";
        String word = "ba";
        int expected = 1;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }

    @Test
    public void checkTestcase03() {
        String sequence = "ababc";
        String word = "ac";
        int expected = 0;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }

    @Test
    public void checkTestcase04() {
        String sequence = "ababac";
        String word = "aba";
        int expected = 1;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }
    /*
    1  0  1  0  1  0
    1  2  1  2  1  0
    1  2  1  0  1  0
     */

    @Test
    public void checkTestcase05() {
        String sequence = "aaaaaaa";
        String word = "aaa";
        int expected = 2;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }

    @Test
    public void checkTestcase06() {
        String sequence = "aaaaaaaaa";
        String word = "aaaa";
        int expected = 2;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }

    @Test
    public void checkTestcase07() {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        int expected = 5;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }

    @Test
    public void checkTestcase08() {
        String sequence = "baba";
        String word = "b";
        int expected = 1;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }

    @Test
    public void checkTestcase09() {
        String sequence = "aaa";
        String word = "a";
        int expected = 3;
        assertEquals(expected, testingClass.maxRepeating(sequence, word));
    }
}
