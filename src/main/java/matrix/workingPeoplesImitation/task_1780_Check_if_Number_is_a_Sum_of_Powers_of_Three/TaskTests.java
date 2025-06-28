package matrix.workingPeoplesImitation.task_1780_Check_if_Number_is_a_Sum_of_Powers_of_Three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int n = 12;
        assertTrue(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase02() {
        int n = 91;
        assertTrue(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase03() {
        int n = 21;
        assertFalse(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase04() {
        int n = 11;
        assertFalse(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase05() {
        int n = 12231;
        assertFalse(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase06() {
        int n = 10_000_000;
        assertFalse(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase07() {
        int n = 10;
        assertTrue(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase08() {
        int n = 1;
        assertTrue(testingClass.checkPowersOfThree(n));
    }

    @Test
    public void checkTestcase09() {
        int n = 2;
        assertFalse(testingClass.checkPowersOfThree(n));
    }
}
