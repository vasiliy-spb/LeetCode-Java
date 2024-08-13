package matrix.workingPeoplesImitation.task_40_Combination_Sum_II;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 6),
                List.of(1, 2, 5),
                List.of(1, 7),
                List.of(2, 6)
        );
        assertTrue(areContentListEquals(expected, testingClass.combinationSum2(candidates, target)));
    }

    @Test
    public void checkTestcase02() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 2),
                List.of(5)
        );
        assertTrue(areContentListEquals(expected, testingClass.combinationSum2(candidates, target)));
    }

    @Test
    public void checkTestcase03() {
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 27;
        List<List<Integer>> expected = new ArrayList<>();
        assertTrue(areContentListEquals(expected, testingClass.combinationSum2(candidates, target)));
    }

    @Test
    public void checkTestcase04() {
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
        List<List<Integer>> expected = List.of(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        assertTrue(areContentListEquals(expected, testingClass.combinationSum2(candidates, target)));
    }

    @Test
    public void checkTestcase05() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = new ArrayList<>();
        assertTrue(areContentListEquals(expected, testingClass.combinationSum2(candidates, target)));
    }

    @Test
    public void checkTestcase06() {
        int[] candidates = {4, 4};
        int target = 6;
        List<List<Integer>> expected = new ArrayList<>();
        assertTrue(areContentListEquals(expected, testingClass.combinationSum2(candidates, target)));
    }

    @Test
    public void checkTestcase07() {
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2)
        );
        assertTrue(areContentListEquals(expected, testingClass.combinationSum2(candidates, target)));
    }

    private boolean areContentListEquals(List<List<Integer>> expected, List<List<Integer>> current) {
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> list : expected) {
            List<Integer> modifableList = new ArrayList<>(list);
            modifableList.sort(Comparator.naturalOrder());
            set.add(modifableList);
        }
        for (List<Integer> list : current) {
            List<Integer> modifableList = new ArrayList<>(list);
            modifableList.sort(Comparator.naturalOrder());
            if (!set.contains(modifableList)) {
                return false;
            }
        }
        return true;
    }
}
