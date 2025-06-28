package matrix.workingPeoplesImitation.task_39_Combination_Sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = List.of(List.of(2, 2, 3), List.of(7));
        assertEquals(expected, testingClass.combinationSum(candidates, target));
    }

    @Test
    public void checkTestcase2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5));
        assertEquals(expected, testingClass.combinationSum(candidates, target));
    }

    @Test
    public void checkTestcase3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, testingClass.combinationSum(candidates, target));
    }

}
