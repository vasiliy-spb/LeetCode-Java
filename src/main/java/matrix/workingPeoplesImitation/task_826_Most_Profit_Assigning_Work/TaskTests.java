package matrix.workingPeoplesImitation.task_826_Most_Profit_Assigning_Work;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        int expected = 100;
        assertEquals(expected, testingClass.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void checkTestcase02() {
        int[] difficulty = {85, 47, 57};
        int[] profit = {24, 66, 99};
        int[] worker = {40, 25, 25};
        int expected = 0;
        assertEquals(expected, testingClass.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void checkTestcase03() {
        int[] difficulty = {13, 37, 58};
        int[] profit = {4, 90, 96};
        int[] worker = {34, 73, 45};
        int expected = 190;
        assertEquals(expected, testingClass.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void checkTestcase04() {
        int[] difficulty = {7, 20, 68};
        int[] profit = {26, 28, 57};
        int[] worker = {71, 20, 71};
        int expected = 142;
        assertEquals(expected, testingClass.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void checkTestcase05() {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        int expected = 324;
        assertEquals(expected, testingClass.maxProfitAssignment(difficulty, profit, worker));
    }

}
