package matrix.workingPeoplesImitation.task_1137_N_th_Tribonacci_Number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int n = 4;
        int expected = 4;
        assertEquals(expected, testingClass.tribonacci(n));
    }

    @Test
    public void checkTestcase2() {
        int n = 25;
        int expected = 1389537;
        assertEquals(expected, testingClass.tribonacci(n));
    }

    @Test
    public void checkTestcase3() {
        int n = 37;
        int expected = 2082876103;
        assertEquals(expected, testingClass.tribonacci(n));
    }

}
