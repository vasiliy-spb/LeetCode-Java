package matrix.workingPeoplesImitation.task_2055_Plates_Between_Candles;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        int[] expected = {2, 3};
        assertArrayEquals(expected, testingClass.platesBetweenCandles(s, queries));
    }

    @Test
    public void checkTestcase2() {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        int[] expected = {9, 0, 0, 0, 0};
        assertArrayEquals(expected, testingClass.platesBetweenCandles(s, queries));
    }

}
