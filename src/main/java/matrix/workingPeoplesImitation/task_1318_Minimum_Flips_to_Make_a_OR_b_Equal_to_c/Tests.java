package matrix.workingPeoplesImitation.task_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int a = 2;
        int b = 6;
        int c = 5;
        int expected = 3;
        assertEquals(expected, testingClass.minFlips(a, b, c));
    }

    @Test
    public void checkTestcase2() {
        int a = 4;
        int b = 2;
        int c = 7;
        int expected = 1;
        assertEquals(expected, testingClass.minFlips(a, b, c));
    }

    @Test
    public void checkTestcase3() {
        int a = 1;
        int b = 2;
        int c = 3;
        int expected = 0;
        assertEquals(expected, testingClass.minFlips(a, b, c));
    }

    @Test
    public void checkTestcase4() { // 13 / 64 testcases passed
        int a = 7;
        int b = 7;
        int c = 7;
        int expected = 0;
        assertEquals(expected, testingClass.minFlips(a, b, c));
    }

    @Test
    public void checkTestcase5() { // 20 / 64 testcases passed
        int a = 10;
        int b = 9;
        int c = 1;
        int expected = 3;
        assertEquals(expected, testingClass.minFlips(a, b, c));
    }

    @Test
    public void checkTestcase6() { // 20 / 64 testcases passed
        int a = 43;
        int b = 78;
        int c = 11;
        int expected = 3;
        assertEquals(expected, testingClass.minFlips(a, b, c));
    }

}
