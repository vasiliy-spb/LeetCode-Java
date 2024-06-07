package matrix.workingPeoplesImitation.task_648_Replace_Words;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        assertEquals(expected, testingClass.replaceWords(dictionary, sentence));
    }

    @Test
    public void checkTestcase02() {
        List<String> dictionary = List.of("a", "b", "c");
        String sentence = "aadsfasf absbs bbab cadsfafs";
        String expected = "a a b c";
        assertEquals(expected, testingClass.replaceWords(dictionary, sentence));
    }

    @Test
    public void checkTestcase03() {
        List<String> dictionary = List.of("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String expected = "a a a a a a a a bbb baba a";
        assertEquals(expected, testingClass.replaceWords(dictionary, sentence));
    }
}
