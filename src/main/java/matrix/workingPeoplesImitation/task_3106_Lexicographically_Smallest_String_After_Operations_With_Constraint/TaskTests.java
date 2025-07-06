package matrix.workingPeoplesImitation.task_3106_Lexicographically_Smallest_String_After_Operations_With_Constraint;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
//    private final Solution testingClass = new Solution();
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        String s = "zbbz";
        int k = 3;
        String expected = "aaaz";
        assertEquals(expected, testingClass.getSmallestString(s, k));
    }

    @Test
    public void checkTestcase02() {
        String s = "xaxcd";
        int k = 4;
        String expected = "aawcd";
        assertEquals(expected, testingClass.getSmallestString(s, k));    }

    @Test
    public void checkTestcase03() {
        String s = "lol";
        int k = 0;
        String expected = "lol";
        assertEquals(expected, testingClass.getSmallestString(s, k));    }
}
