package matrix.workingPeoplesImitation.task_875_Koko_Eating_Bananas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int expected = 4;
        assertEquals(expected, testingClass.minEatingSpeed(piles, h));
    }

    @Test
    public void checkTestcase2() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int expected = 30;
        assertEquals(expected, testingClass.minEatingSpeed(piles, h));
    }

    @Test
    public void checkTestcase3() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        int expected = 23;
        assertEquals(expected, testingClass.minEatingSpeed(piles, h));
    }

    @Test
    public void checkTestcase4() { // 123 / 126 testcases passed
        int[] piles = {1000000000};
        int h = 2;
        int expected = 500000000;
        assertEquals(expected, testingClass.minEatingSpeed(piles, h));
    }

    @Test
    public void checkTestcase5() {
        int[] piles = {1000000000};
        int h = 3;
        int expected = 333333334;
        assertEquals(expected, testingClass.minEatingSpeed(piles, h));
    }

    @Test
    public void checkTestcase6() { // 124 / 126 testcases passed
        int[] piles = {3, 6, 7, 100, 1, 1, 1, 1, 1};
        int h = 10;
        int expected = 50;
        assertEquals(expected, testingClass.minEatingSpeed(piles, h));
    }

}
