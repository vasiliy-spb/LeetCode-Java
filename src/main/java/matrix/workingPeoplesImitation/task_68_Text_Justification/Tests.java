package matrix.workingPeoplesImitation.task_68_Text_Justification;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> expected = List.of(
                "This    is    an",
                "example  of text",
                "justification.  ");
        assertEquals(expected, testingClass.fullJustify(words, maxWidth));
    }

    @Test
    public void checkTestcase02() {
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> expected = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        ");
        assertEquals(expected, testingClass.fullJustify(words, maxWidth));
    }

    @Test
    public void checkTestcase03() {
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        List<String> expected = List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  ");
        assertEquals(expected, testingClass.fullJustify(words, maxWidth));
    }

    @Test
    public void checkTestcase04() { // 25 / 29 testcases passed
        String[] words = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        List<String> expected = List.of(
                "ask   not   what",
                "your country can",
                "do  for  you ask",
                "what  you can do",
                "for your country");
        assertEquals(expected, testingClass.fullJustify(words, maxWidth));
    }
}
