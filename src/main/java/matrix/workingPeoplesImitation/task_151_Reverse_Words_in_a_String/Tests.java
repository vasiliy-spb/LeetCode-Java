package matrix.workingPeoplesImitation.task_151_Reverse_Words_in_a_String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        String input = "the sky is blue";
        String expected = "blue is sky the";
        assertEquals(expected, testingClass.reverseWords(input));
    }

    @Test
    public void makeTestcase2() {
        String input = "  hello world  ";
        String expected = "world hello";
        assertEquals(expected, testingClass.reverseWords(input));
    }

    @Test
    public void makeTestcase3() {
        String input = "a good   example";
        String expected = "example good a";
        assertEquals(expected, testingClass.reverseWords(input));
    }

}
