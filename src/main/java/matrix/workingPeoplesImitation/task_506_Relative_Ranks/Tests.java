package matrix.workingPeoplesImitation.task_506_Relative_Ranks;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] score = {5, 4, 3, 2, 1};
        String[] expected = {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
        assertArrayEquals(expected, testingClass.findRelativeRanks(score));
    }

    @Test
    public void checkTestcase02() {
        int[] score = {10, 3, 8, 9, 4};
        String[] expected = {"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"};
        assertArrayEquals(expected, testingClass.findRelativeRanks(score));
    }
}
