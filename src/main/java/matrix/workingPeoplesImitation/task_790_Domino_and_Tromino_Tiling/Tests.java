package matrix.workingPeoplesImitation.task_790_Domino_and_Tromino_Tiling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int n = 3;
        int expected = 5;
        assertEquals(expected, testingClass.numTilings(n));
    }

    @Test
    public void checkTestcase2() {
        int n = 1;
        int expected = 1;
        assertEquals(expected, testingClass.numTilings(n));
    }

    @Test
    public void checkTestcase3() { // 3 / 39 testcases passed
        int n = 4;
        int expected = 11;
        assertEquals(expected, testingClass.numTilings(n));
    }

    @Test
    public void checkTestcase4() { // 4 / 39 testcases passed
        int n = 5;
        int expected = 24;
        assertEquals(expected, testingClass.numTilings(n));
    }

    @Test
    public void checkTestcase5() { // 5 / 39 testcases passed
        int n = 6;
        int expected = 53;
        assertEquals(expected, testingClass.numTilings(n));
    }

    @Test
    public void checkTestcase6() {
        int n = 7;
        int expected = 117;
        assertEquals(expected, testingClass.numTilings(n));
    }

    @Test
    public void checkTestcase7() { // 11 / 39 testcases passed
        int n = 30;
        int expected = 312342182;
        assertEquals(expected, testingClass.numTilings(n));
    }

}
