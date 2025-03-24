package matrix.workingPeoplesImitation.task_3169_Count_Days_Without_Meetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        int expected = 2;
        assertEquals(expected, testingClass.countDays(days, meetings));
    }

    @Test
    public void checkTestcase02() {
        int days = 5;
        int[][] meetings = {{2, 4}, {1, 3}};
        int expected = 1;
        assertEquals(expected, testingClass.countDays(days, meetings));
    }

    @Test
    public void checkTestcase03() {
        int days = 6;
        int[][] meetings = {{1, 6}};
        int expected = 0;
        assertEquals(expected, testingClass.countDays(days, meetings));
    }

    @Test
    public void checkTestcase04() {
        int days = 14;
        int[][] meetings = {{6, 11}, {7, 13}, {8, 9}, {5, 8}, {3, 13}, {11, 13}, {1, 3}, {5, 10}, {8, 13}, {3, 9}};
        int expected = 1;
        assertEquals(expected, testingClass.countDays(days, meetings));
    }

    @Test
    public void checkTestcase05() {
        int days = 50;
        int[][] meetings = {{22, 31}, {7, 42}, {30, 46}, {9, 33}, {9, 18}, {23, 39}, {4, 8}, {18, 19}};
        int expected = 7;
        assertEquals(expected, testingClass.countDays(days, meetings));
    }
}
