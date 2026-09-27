package matrix.workingPeoplesImitation.task_318_Maximum_Product_of_Word_Lengths;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int expected = 16;
        assertEquals(expected, testingClass.maxProduct(words));
    }

    @Test
    public void checkTestcase02() {
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        int expected = 4;
        assertEquals(expected, testingClass.maxProduct(words));
    }

    @Test
    public void checkTestcase03() {
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int expected = 0;
        assertEquals(expected, testingClass.maxProduct(words));
    }
}
