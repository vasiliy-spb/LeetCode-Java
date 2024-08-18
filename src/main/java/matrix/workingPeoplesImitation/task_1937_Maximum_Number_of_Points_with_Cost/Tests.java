package matrix.workingPeoplesImitation.task_1937_Maximum_Number_of_Points_with_Cost;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] points = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        int expected = 9;
        assertEquals(expected, testingClass.maxPoints(points));
    }

    @Test
    public void checkTestcase02() {
        int[][] points = {{1, 5}, {2, 3}, {4, 2}};
        int expected = 11;
        assertEquals(expected, testingClass.maxPoints(points));
    }

    @Test
    public void checkTestcase03() {
        int[][] points = {
                {5, 3},
                {3, 5},
                {3, 1}
        };
        int expected = 11;
        assertEquals(expected, testingClass.maxPoints(points));
    }

    @Test
    public void checkTestcase04() {
        int[][] points = {
                {Integer.MAX_VALUE},
                {Integer.MAX_VALUE},
                {Integer.MAX_VALUE}
        };
        long expected = Integer.MAX_VALUE * 3L;
        assertEquals(expected, testingClass.maxPoints(points));
    }
}
