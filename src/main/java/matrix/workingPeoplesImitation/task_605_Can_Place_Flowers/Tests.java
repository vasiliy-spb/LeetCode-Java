package matrix.workingPeoplesImitation.task_605_Can_Place_Flowers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        assertTrue(testingClass.canPlaceFlowers(flowerbed, n));
    }

    @Test
    public void checkTestcase2() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        assertFalse(testingClass.canPlaceFlowers(flowerbed, n));
    }

    @Test
    public void checkTestcase3() {
        int[] flowerbed = {0};
        int n = 2;
        assertFalse(testingClass.canPlaceFlowers(flowerbed, n));
    }

    @Test
    public void checkTestcase4() {
        int[] flowerbed = {0};
        int n = 1;
        assertTrue(testingClass.canPlaceFlowers(flowerbed, n));
    }

    @Test
    public void checkTestcase5() {
        int[] flowerbed = {1};
        int n = 1;
        assertFalse(testingClass.canPlaceFlowers(flowerbed, n));
    }

    @Test
    public void checkTestcase6() { // 127 / 129 testcases passed
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 2;
        assertFalse(testingClass.canPlaceFlowers(flowerbed, n));
    }

}
