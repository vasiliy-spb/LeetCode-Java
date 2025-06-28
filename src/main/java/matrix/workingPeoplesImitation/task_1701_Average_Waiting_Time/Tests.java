package matrix.workingPeoplesImitation.task_1701_Average_Waiting_Time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] customers = {{1, 2}, {2, 5}, {4, 3}};
        double expected = 5.00000;
        assertEquals(expected, testingClass.averageWaitingTime(customers),0.00001);
    }

    @Test
    public void checkTestcase02() {
        int[][] customers = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        double expected = 3.25000;
        assertEquals(expected, testingClass.averageWaitingTime(customers),0.00001);
    }

    @Test
    public void checkTestcase03() {
        int[][] customers = {{2, 3}, {6, 3}, {7, 5}, {11, 3}, {15, 2}, {18, 1}};
        double expected = 4.16667;
        assertEquals(expected, testingClass.averageWaitingTime(customers),0.00001);
    }
}
