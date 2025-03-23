package matrix.workingPeoplesImitation.task_835_Image_Overlap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] img1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] img2 = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        int expected = 3;
        assertEquals(expected, testingClass.largestOverlap(img1, img2));
    }

    @Test
    public void checkTestcase02() {
        int[][] img1 = {{1}};
        int[][] img2 = {{1}};
        int expected = 1;
        assertEquals(expected, testingClass.largestOverlap(img1, img2));
    }

    @Test
    public void checkTestcase03() {
        int[][] img1 = {{0}};
        int[][] img2 = {{0}};
        int expected = 0;
        assertEquals(expected, testingClass.largestOverlap(img1, img2));
    }

    @Test
    public void checkTestcase04() {
        int[][] img1 = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] img2 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0}
        };
        int expected = 1;
        assertEquals(expected, testingClass.largestOverlap(img1, img2));
    }

    @Test
    public void checkTestcase05() {
        int[][] img1 = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}};
        int[][] img2 = {{0, 1, 1}, {0, 0, 0}, {0, 0, 0}};
        int expected = 2;
        assertEquals(expected, testingClass.largestOverlap(img1, img2));
    }

    @Test
    public void checkTestcase06() {
        int[][] img1 = {{1, 1, 1}, {1, 0, 0}, {0, 1, 1}};
        int[][] img2 = {{1, 1, 0}, {1, 1, 1}, {1, 1, 0}};
        int expected = 4;
        assertEquals(expected, testingClass.largestOverlap(img1, img2));
    }

    @Test
    public void checkTestcase07() {
        int[][] img1 = {{0, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 0, 0}};
        int[][] img2 = {{0, 0, 0, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}};
        int expected = 9;
        assertEquals(expected, testingClass.largestOverlap(img1, img2));
    }
}
