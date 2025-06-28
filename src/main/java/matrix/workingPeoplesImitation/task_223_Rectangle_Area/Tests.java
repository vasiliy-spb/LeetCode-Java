package matrix.workingPeoplesImitation.task_223_Rectangle_Area;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int ax1 = -3;
        int ay1 = 0;
        int ax2 = 3;
        int ay2 = 4;
        int bx1 = 0;
        int by1 = -1;
        int bx2 = 9;
        int by2 = 2;
        int expected = 45;
        assertEquals(expected, testingClass.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    @Test
    public void checkTestcase02() {
        int ax1 = -2;
        int ay1 = -2;
        int ax2 = 2;
        int ay2 = 2;
        int bx1 = -2;
        int by1 = -2;
        int bx2 = 2;
        int by2 = 2;
        int expected = 16;
        assertEquals(expected, testingClass.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    @Test
    public void checkTestcase03() {
        int ax1 = 0;
        int ay1 = 0;
        int ax2 = 0;
        int ay2 = 0;
        int bx1 = -1;
        int by1 = -1;
        int bx2 = 1;
        int by2 = 1;
        int expected = 4;
        assertEquals(expected, testingClass.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    @Test
    public void checkTestcase04() {
        int ax1 = -2;
        int ay1 = -2;
        int ax2 = 2;
        int ay2 = 2;
        int bx1 = 3;
        int by1 = 3;
        int bx2 = 4;
        int by2 = 4;
        int expected = 17;
        assertEquals(expected, testingClass.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    @Test
    public void checkTestcase05() {
        int ax1 = -2;
        int ay1 = -2;
        int ax2 = 2;
        int ay2 = 2;
        int bx1 = -1;
        int by1 = -1;
        int bx2 = 1;
        int by2 = 1;
        int expected = 16;
        assertEquals(expected, testingClass.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
