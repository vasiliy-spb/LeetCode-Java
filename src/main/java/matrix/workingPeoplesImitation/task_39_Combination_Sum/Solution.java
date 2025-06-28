package matrix.workingPeoplesImitation.task_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates != null && candidates.length > 0)
            findCombination(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void findCombination(int[] candidates, int target, List<Integer> currentList, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentList.add(candidates[i]);
                findCombination(candidates, target - candidates[i], currentList, result, i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
