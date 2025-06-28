package matrix.workingPeoplesImitation.task_820_Short_Encoding_of_Words;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] words = {"time", "me", "bell"};
        int expected = 10;
        assertEquals(expected, testingClass.minimumLengthEncoding(words));
    }

    @Test
    public void checkTestcase02() {
        String[] words = {"t"};
        int expected = 2;
        assertEquals(expected, testingClass.minimumLengthEncoding(words));
    }

    @Test
    public void checkTestcase03() {
        String[] words = {"temp", "mp", "tem"};
        int expected = 9;
        assertEquals(expected, testingClass.minimumLengthEncoding(words));
    }

    @Test
    public void checkTestcase04() {
        String[] words = {"temp", "emp"};
        int expected = 5;
        assertEquals(expected, testingClass.minimumLengthEncoding(words));
    }
}
