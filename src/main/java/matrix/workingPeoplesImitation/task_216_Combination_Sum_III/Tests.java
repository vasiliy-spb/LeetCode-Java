package matrix.workingPeoplesImitation.task_216_Combination_Sum_III;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int k = 3;
        int n = 7;
        List<List<Integer>> expected = List.of(List.of(1, 2, 4));
        assertEquals(expected, testingClass.combinationSum3(k, n));
    }

    @Test
    public void checkTestcase2() {
        int k = 3;
        int n = 9;
        List<List<Integer>> expected = List.of(List.of(1, 2, 6), List.of(1, 3, 5), List.of(2, 3, 4));
        assertEquals(expected, testingClass.combinationSum3(k, n));
    }

    @Test
    public void checkTestcase3() {
        int k = 4;
        int n = 1;
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, testingClass.combinationSum3(k, n));
    }

}
