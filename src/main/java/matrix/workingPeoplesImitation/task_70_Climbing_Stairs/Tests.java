package matrix.workingPeoplesImitation.task_70_Climbing_Stairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int n = 2;
        int expected = 2;
        assertEquals(expected, testingClass.climbStairs(n));
    }

    @Test
    public void checkTestcase2() {
        int n = 3;
        int expected = 3;
        assertEquals(expected, testingClass.climbStairs(n));
    }

}
