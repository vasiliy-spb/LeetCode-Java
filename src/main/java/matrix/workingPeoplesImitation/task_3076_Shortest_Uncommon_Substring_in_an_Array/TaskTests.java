package matrix.workingPeoplesImitation.task_3076_Shortest_Uncommon_Substring_in_an_Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        String[] arr = {"cab", "ad", "bad", "c"};
        String[] expected = {"ab", "", "ba", ""};
        assertArrayEquals(expected, testingClass.shortestSubstrings(arr));
    }

    @Test
    public void checkTestcase02() {
        String[] arr = {"abc", "bcd", "abcd"};
        String[] expected = {"", "", "abcd"};
        assertArrayEquals(expected, testingClass.shortestSubstrings(arr));
    }

    @Test
    public void checkTestcase03() {
        String[] arr = {"cab", "ad", "bade", "c"};
        String[] expected = {"ab", "", "e", ""};
        assertArrayEquals(expected, testingClass.shortestSubstrings(arr));
    }
}
