package matrix.workingPeoplesImitation.task_1007_Minimum_Domino_Rotations_For_Equal_Row;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};
        int expected = 2;
        assertEquals(expected, testingClass.minDominoRotations(tops, bottoms));
    }

    @Test
    public void checkTestcase02() {
        int[] tops = {3, 5, 1, 2, 3};
        int[] bottoms = {3, 6, 3, 3, 4};
        int expected = -1;
        assertEquals(expected, testingClass.minDominoRotations(tops, bottoms));
    }

    @Test
    public void checkTestcase03() {
        int[] tops =    {1, 2, 1, 1, 1, 2, 2, 2};
        int[] bottoms = {2, 1, 2, 2, 2, 2, 2, 2};
        int expected = 1;
        assertEquals(expected, testingClass.minDominoRotations(tops, bottoms));
    }

    @Test
    public void checkTestcase04() {
        int[] tops =    {2,1,1,3,2,1,2,2,1};
        int[] bottoms = {3,2,3,1,3,2,3,3,2};
        int expected = -1;
        assertEquals(expected, testingClass.minDominoRotations(tops, bottoms));
    }
}
