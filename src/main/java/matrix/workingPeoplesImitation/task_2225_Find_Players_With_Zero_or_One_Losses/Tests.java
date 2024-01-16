package matrix.workingPeoplesImitation.task_2225_Find_Players_With_Zero_or_One_Losses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4},{10,9}};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,2,10), Arrays.asList(4,5,7,8));
        assertEquals(expected, testingClass.findWinners(matches));
    }

    @Test
    public void checkTestcase2() {
        int[][] matches = {{2, 3},{1, 3},{5, 4},{6, 4}};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,2,5,6), new ArrayList<>());
        assertEquals(expected, testingClass.findWinners(matches));
    }

}
