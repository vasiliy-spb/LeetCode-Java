package matrix.workingPeoplesImitation.task_2462_Total_Cost_to_Hire_K_Workers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k = 3;
        int candidates = 4;
        int expected = 11;
        assertEquals(expected, testingClass.totalCost(costs, k, candidates));
    }

    @Test
    public void checkTestcase2() {
        int[] costs = {1, 2, 4, 1};
        int k = 3;
        int candidates = 3;
        int expected = 4;
        assertEquals(expected, testingClass.totalCost(costs, k, candidates));
    }

    @Test
    public void checkTestcase3() { // 20 / 162 testcases passed
        int[] costs = {57, 33, 26, 76, 14, 67, 24, 90, 72, 37, 30};
        int k = 11;
        int candidates = 2;
        int expected = 526;
        assertEquals(expected, testingClass.totalCost(costs, k, candidates));
    }

    @Test
    public void checkTestcase4() { // 160 / 162 testcases passed
        int[] costs = {48};
        int k = 1;
        int candidates = 1;
        int expected = 48;
        assertEquals(expected, testingClass.totalCost(costs, k, candidates));
    }

    @Test
    public void checkTestcase5() { // 160 / 162 testcases passed
        int[] costs = {2, 2, 2, 2, 2, 2, 1, 4, 5, 5, 5, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int k = 7;
        int candidates = 3;
        int expected = 13;
        assertEquals(expected, testingClass.totalCost(costs, k, candidates));
    }

    @Test
    public void checkTestcase6() { // 149 / 162 testcases passed
        int[] costs = {25, 20, 60, 21, 11, 99, 55, 22, 83, 62, 12, 63, 100, 41, 33, 92, 13, 92, 58, 85, 61, 93, 5, 46, 26, 25, 36, 27, 12, 30, 13, 52, 30};
        int k = 8;
        int candidates = 22;
        int expected = 107;
        assertEquals(expected, testingClass.totalCost(costs, k, candidates));
    }

    @Test
    public void checkTestcase7() { // 161 / 162 testcases passed
        int[] costs = {17, 12};
        int k = 1;
        int candidates = 1;
        int expected = 12;
        assertEquals(expected, testingClass.totalCost(costs, k, candidates));
    }

}
