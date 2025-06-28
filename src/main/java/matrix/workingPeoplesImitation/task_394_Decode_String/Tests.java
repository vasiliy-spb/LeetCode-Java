package matrix.workingPeoplesImitation.task_394_Decode_String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "3[a]2[bc]";
        String expected = "aaabcbc";
        assertEquals(expected, testingClass.decodeString(s));
    }

    @Test
    public void checkTestcase2() {
        String s = "3[a2[c]]";
        String expected = "accaccacc";
        assertEquals(expected, testingClass.decodeString(s));
    }

    @Test
    public void checkTestcase3() {
        String s = "2[abc]3[cd]ef";
        String expected = "abcabccdcdcdef";
        assertEquals(expected, testingClass.decodeString(s));
    }

}
