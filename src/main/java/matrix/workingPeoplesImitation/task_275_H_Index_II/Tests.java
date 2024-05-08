package matrix.workingPeoplesImitation.task_275_H_Index_II;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] citations = {0, 1, 3, 5, 6};
        int expected = 3;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase02() {
        int[] citations = {1, 2, 100};
        int expected = 2;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase03() {
        int[] citations = {100};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase04() {
        int[] citations = {1, 2, 2};
        int expected = 2;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase05() {
        int[] citations = {1, 2};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase06() {
        int[] citations = {0, 1};
        int expected = 1;
        assertEquals(expected, testingClass.hIndex(citations));
    }

    @Test
    public void checkTestcase07() {
        int[] citations = {11, 15};
        int expected = 2;
        assertEquals(expected, testingClass.hIndex(citations));
    }

//    @Test
//    public void checkTestcase08() {
//        int[] citations = {0, 1, 0};
//        int expected = 1;
//        assertEquals(expected, testingClass.hIndex(citations));
//    }

    @Test
    public void checkTestcase09() {
        int[] citations = {0, 0};
        int expected = 0;
        assertEquals(expected, testingClass.hIndex(citations));
    }

//    @Test
//    public void checkTestcase10() {
//        int[] citations = {1, 2, 1, 2};
//        int expected = 2;
//        assertEquals(expected, testingClass.hIndex(citations));
//    }
//
//    @Test
//    public void checkTestcase11() {
//        int[] citations = {4, 4, 0, 0};
//        int expected = 2;
//        assertEquals(expected, testingClass.hIndex(citations));
//    }
}
