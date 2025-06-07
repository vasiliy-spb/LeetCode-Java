package matrix.workingPeoplesImitation.task_3170_Lexicographically_Minimum_String_After_Removing_Stars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
//    private final Solution testingClass = new Solution();
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        String s = "aaba*";
        String expected = "aab";
        assertEquals(expected, testingClass.clearStars(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "abc";
        String expected = "abc";
        assertEquals(expected, testingClass.clearStars(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "abac*bc";
        String expected = "abcbc";
        assertEquals(expected, testingClass.clearStars(s));
    }

    @Test
    public void checkTestcase04() {
        String s = "abac*bc*";
        String expected = "bcbc";
        assertEquals(expected, testingClass.clearStars(s));
    }

    @Test
    public void checkTestcase05() {
        String s = "d*o*";
        String expected = "";
        assertEquals(expected, testingClass.clearStars(s));
    }
}
