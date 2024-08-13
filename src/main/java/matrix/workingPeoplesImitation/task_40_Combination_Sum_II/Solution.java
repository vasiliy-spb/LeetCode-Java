package matrix.workingPeoplesImitation.task_40_Combination_Sum_II;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Set<Set<Integer>> result = new HashSet<>();
//        Set<Integer> visited = new HashSet<>();
//        collectCombinations(candidates, target, result, new HashSet<>(), 0, visited);
//        List<List<Integer>> ans = new ArrayList<>();
//        for (Set<Integer> set : result)
//            ans.add(set.stream().toList());
//        return ans;
//    }
//
//    private void collectCombinations(int[] candidates, int target, Set<Set<Integer>> result, Set<Integer> currentCombination, int index, Set<Integer> visited) {
//        if (index >= candidates.length) return;
//        if (target == 0) {
//            result.add(new HashSet<>(currentCombination));
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            if (visited.contains(i)) continue;
//            if (candidates[i] <= target) {
//                currentCombination.add(candidates[i]);
//                visited.add(i);
//                collectCombinations(candidates, target - candidates[i], result, new HashSet<>(currentCombination), i + 1, new HashSet<>(visited));
//                currentCombination.remove(currentCombination.size() - 1);
//                visited.remove(i);
//            }
//        }
//    }

//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Set<Integer> visited = new HashSet<>();
//        collectCombinations(candidates, target, result, new ArrayList<>(), 0, visited);
//        return result;
//    }
//
//    private void collectCombinations(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentCombination, int index, Set<Integer> visited) {
////        if (target < 0 || index >= candidates.length) return;
//        if (target == 0) {
//            result.add(new ArrayList<>(currentCombination));
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
////            if (visited.contains(i)) continue;
//            if (candidates[i] <= target) {
//                currentCombination.add(candidates[i]);
////                visited.add(i);
//                collectCombinations(candidates, target - candidates[i], result, currentCombination, index + 1, new HashSet<>(visited));
//                currentCombination.remove(currentCombination.size() - 1);
////                visited.remove(i);
//            }
//        }
//    }
    // 10, 1, 2, 7, 6, 1, 5

    // TLE
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Set<Set<Integer>> result = new HashSet<>();
//        collectCombinations(candidates, target, result, new HashSet<>(), 0);
//        Set<List<Integer>> ansSet = new HashSet<>();
//        for (Set<Integer> set : result) {
//            ansSet.add(set.stream().map(i -> candidates[i]).sorted().toList());
//        }
//        return new ArrayList<>(ansSet);
//    }
//
//    private void collectCombinations(int[] candidates, int target, Set<Set<Integer>> result, Set<Integer> currentCombination, int index) {
//        if (target == 0) {
//            result.add(new HashSet<>(currentCombination));
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            if (candidates[i] <= target) {
//                currentCombination.add(i);
//                collectCombinations(candidates, target - candidates[i], result, new HashSet<>(currentCombination), i + 1);
//                currentCombination.remove(i);
//            }
//        }
//    }

    // my solution
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        collectCombinations(candidates, target, result, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }
    private void collectCombinations(int[] candidates, int target, Set<List<Integer>> result, List<Integer> currentCombination, int index) {
        if (target == 0) {
            result.add(currentCombination);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; // чтобы не начинать несколько раз с одинаковых элементов
            if (candidates[i] <= target) {
                currentCombination.add(candidates[i]);
                collectCombinations(candidates, target - candidates[i], result, new ArrayList<>(currentCombination), i + 1);
                currentCombination.remove(currentCombination.size() - 1);
            } else {
                break;
            }
        }
    }

    // from leetcode editorial
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(
            List<List<Integer>> answer,
            List<Integer> tempList,
            int[] candidates,
            int totalLeft,
            int index
    ) {
        if (totalLeft < 0) return;
        else if (totalLeft == 0) { // Add to the answer array, if the sum is equal to target.
            answer.add(new ArrayList<>(tempList));
        } else {
            for (
                    int i = index;
                    i < candidates.length && totalLeft >= candidates[i];
                    i++
            ) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                // Add it to tempList.
                tempList.add(candidates[i]);
                // Check for all possible scenarios.
                backtrack(
                        answer,
                        tempList,
                        candidates,
                        totalLeft - candidates[i],
                        i + 1
                );
                // Backtrack the tempList.
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // from walkccc.me
    public List<List<Integer>> combinationSum23(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int s, int[] candidates, int target, List<Integer> path, List<List<Integer>> ans) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = s; i < candidates.length; ++i) {
            if (i > s && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i], path, ans);
            path.remove(path.size() - 1);
        }
    }

}
