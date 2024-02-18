package matrix.workingPeoplesImitation.task_1642_Furthest_Building_You_Can_Reach;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;
        int expected = 4;
        assertEquals(expected, testingClass.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void checkTestcase2() {
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10;
        int ladders = 2;
        int expected = 7;
        assertEquals(expected, testingClass.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void checkTestcase3() {
        int[] heights = {14, 3, 19, 3};
        int bricks = 17;
        int ladders = 0;
        int expected = 3;
        assertEquals(expected, testingClass.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void checkTestcase4() {
        int[] heights = {1, 5, 1, 2, 3, 4, 10000};
        int bricks = 4;
        int ladders = 1;
        int expected = 5;
        assertEquals(expected, testingClass.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void checkTestcase5() {
        int[] heights = {2, 7, 9, 12};
        int bricks = 5;
        int ladders = 1;
        int expected = 3;
        assertEquals(expected, testingClass.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void checkTestcase6() {
        int[] heights = {1, 2};
        int bricks = 0;
        int ladders = 0;
        int expected = 0;
        assertEquals(expected, testingClass.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void checkTestcase7() {
        int[] heights = {4, 2, 6, 6, 9, 8, 9, 12};
        int bricks = 5;
        int ladders = 0;
        int expected = 3;
        assertEquals(expected, testingClass.furthestBuilding(heights, bricks, ladders));
    }

}
