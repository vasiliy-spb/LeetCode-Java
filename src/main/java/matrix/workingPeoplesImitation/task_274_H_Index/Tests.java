package matrix.workingPeoplesImitation.task_274_H_Index;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] citations = {3, 0, 6, 1, 5};
        int expected = 3;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase02() {
        int[] citations = {1, 3, 1};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase03() { // 37 / 82 testcases passed
        int[] citations = {100};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase04() { // 37 / 82 testcases passed
        int[] citations = {0};
        int expected = 0;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase05() { // 38 / 82 testcases passed
        int[] citations = {1, 2};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase06() { // 37 / 82 testcases passed
        int[] citations = {0, 1};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase07() { // 39 / 82 testcases passed
        int[] citations = {11, 15};
        int expected = 2;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase08() { // 50 / 82 testcases passed
        int[] citations = {0, 1, 0};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase09() { // 5 / 82 testcases passed
        int[] citations = {0, 0};
        int expected = 0;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase10() { // 52 / 82 testcases passed
        int[] citations = {1, 2, 1, 2};
        int expected = 2;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase11() { // 69 / 82 testcases passed
        int[] citations = {4, 4, 0, 0};
        int expected = 2;
        assertEquals(expected, testingClass.hIndex(citations));
    }
}
