package matrix.workingPeoplesImitation.task_890_Find_and_Replace_Pattern;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> expected = List.of("mee", "aqq");
        assertEquals(expected, testingClass.findAndReplacePattern(words, pattern));
    }

    @Test
    public void checkTestcase02() {
        String[] words = {"a", "b", "c"};
        String pattern = "a";
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, testingClass.findAndReplacePattern(words, pattern));
    }

    @Test
    public void checkTestcase03() {
        String[] words = {"badc", "abab", "dddd", "dede", "yyxx"};
        String pattern = "baba";
        List<String> expected = List.of("abab", "dede");
        assertEquals(expected, testingClass.findAndReplacePattern(words, pattern));
    }
}
