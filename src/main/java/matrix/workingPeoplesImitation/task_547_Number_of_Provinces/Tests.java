package matrix.workingPeoplesImitation.task_547_Number_of_Provinces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int expected = 2;
        assertEquals(expected, testingClass.findCircleNum(isConnected));
    }

    @Test
    public void checkTestcase2() {
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int expected = 3;
        assertEquals(expected, testingClass.findCircleNum(isConnected));
    }

    @Test
    public void checkTestcase3() { // 36 / 114 testcases passed
        int[][] isConnected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int expected = 1;
        assertEquals(expected, testingClass.findCircleNum(isConnected));
    }

}
