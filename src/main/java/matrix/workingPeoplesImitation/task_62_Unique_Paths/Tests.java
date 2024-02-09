package matrix.workingPeoplesImitation.task_62_Unique_Paths;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int m = 3;
        int n = 7;
        int expected = 28;
        assertEquals(expected, testingClass.uniquePaths(m, n));
    }

    @Test
    public void checkTestcase2() {
        int m = 3;
        int n = 2;
        int expected = 3;
        assertEquals(expected, testingClass.uniquePaths(m, n));
    }

}
