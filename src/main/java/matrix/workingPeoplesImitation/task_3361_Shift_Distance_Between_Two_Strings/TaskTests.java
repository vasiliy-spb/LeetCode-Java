package matrix.workingPeoplesImitation.task_3361_Shift_Distance_Between_Two_Strings;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
//    private final Solution testingClass = new Solution();
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        String s = "abab";
        String t = "baba";
        int[] nextCost = {100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] previousCost = {1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        long expected = 2;
        assertEquals(expected, testingClass.shiftDistance(s, t, nextCost, previousCost));
    }

    @Test
    public void checkTestcase02() {
        String s = "leet";
        String t = "code";
        int[] nextCost = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] previousCost = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        long expected = 31;
        assertEquals(expected, testingClass.shiftDistance(s, t, nextCost, previousCost));
    }

    @Test
    public void checkTestcase03() {
        String s = "aaaaa";
        String t = "bbbbb";
        int[] nextCost = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] previousCost = {1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000};
        long expected = 0;
        assertEquals(expected, testingClass.shiftDistance(s, t, nextCost, previousCost));
    }

    @Test
    public void checkTestcase04() {
        String s = "ccdbbcaadb";
        String t = "aadbbdaaac";
        int[] nextCost = {6, 6, 9, 8, 2, 4, 10, 10, 6, 4, 9, 5, 5, 5, 2, 7, 9, 7, 4, 1, 4, 10, 1, 5, 2, 4};
        int[] previousCost = {0, 4, 5, 6, 7, 10, 5, 5, 8, 1, 1, 10, 7, 8, 10, 8, 7, 2, 3, 3, 6, 3, 0, 6, 4, 0};
        long expected = 48;
        assertEquals(expected, testingClass.shiftDistance(s, t, nextCost, previousCost));
    } // 9 9 0 0 0 9 0 0 15 6
}
