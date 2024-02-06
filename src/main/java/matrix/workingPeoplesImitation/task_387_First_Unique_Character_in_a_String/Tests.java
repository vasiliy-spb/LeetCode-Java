package matrix.workingPeoplesImitation.task_387_First_Unique_Character_in_a_String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "leetcode";
        int expected = 0;
        assertEquals(expected, testingClass.firstUniqChar(s));
    }

    @Test
    public void checkTestcase2() {
        String s = "loveleetcode";
        int expected = 2;
        assertEquals(expected, testingClass.firstUniqChar(s));
    }

    @Test
    public void checkTestcase3() {
        String s = "aabb";
        int expected = -1;
        assertEquals(expected, testingClass.firstUniqChar(s));
    }

}
