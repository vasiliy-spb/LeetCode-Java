package matrix.workingPeoplesImitation.task_1716_Calculate_Money_in_Leetcode_Bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int n = 4;
        int expected = 10;
        assertEquals(expected, testingClass.totalMoney(n));
    }

    @Test
    public void checkTestcase02() {
        int n = 10;
        int expected = 37;
        assertEquals(expected, testingClass.totalMoney(n));
    }

    @Test
    public void checkTestcase03() {
        int n = 20;
        int expected = 96;
        assertEquals(expected, testingClass.totalMoney(n));
    }

    @Test
    public void checkTestcase04() {
        int n = 50;
        int expected = 351;
        assertEquals(expected, testingClass.totalMoney(n));
    }
}
