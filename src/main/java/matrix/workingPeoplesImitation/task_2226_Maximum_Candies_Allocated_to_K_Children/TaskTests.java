package matrix.workingPeoplesImitation.task_2226_Maximum_Candies_Allocated_to_K_Children;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] candies = {5, 8, 6};
        int k = 3;
        int expected = 5;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase02() {
        int[] candies = {2, 5};
        int k = 11;
        int expected = 0;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase03() {
        int[] candies = {1, 3, 2};
        int k = 5;
        int expected = 1;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase04() {
        int[] candies = {1, 3};
        int k = 2;
        int expected = 1;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase05() {
        int[] candies = {1, 3, 1};
        int k = 2;
        int expected = 1;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase06() {
        int[] candies = {2, 6, 4};
        int k = 5;
        int expected = 2;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase07() {
        int[] candies = {2, 6, 5};
        int k = 5;
        int expected = 2;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase08() {
        int[] candies = {9, 10, 1, 2, 10, 9, 9, 10, 2, 2};
        int k = 3;
        int expected = 10;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase09() {
        int[] candies = {1, 2, 3, 4, 10};
        int k = 5;
        int expected = 3;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }

    @Test
    public void checkTestcase10() {
        int[] candies = {1, 2, 6, 8, 6, 7, 3, 5, 2, 5};
        int k = 3;
        int expected = 6;
        assertEquals(expected, testingClass.maximumCandies(candies, k));
    }
}
