package matrix.workingPeoplesImitation.task_746_Min_Cost_Climbing_Stairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] cost = {10, 15, 20};
        int expected = 15;
        assertEquals(expected, testingClass.minCostClimbingStairs(cost));
    }

    @Test
    public void checkTestcase2() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int expected = 6;
        assertEquals(expected, testingClass.minCostClimbingStairs(cost));
    }

}
