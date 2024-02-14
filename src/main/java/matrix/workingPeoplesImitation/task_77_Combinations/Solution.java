package matrix.workingPeoplesImitation.task_77_Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // my solution
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        makeCombinations(n, k, new ArrayList<>(), result, 1);
        return result;
    }

    private void makeCombinations(int n, int k, List<Integer> currentList, List<List<Integer>> result, int start) {
        if (currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i <= n; i++) {
            currentList.add(i);
            makeCombinations(n, k, currentList, result, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }

    // from leetcode solutions
    public List<List<Integer>> combine2(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine2(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine2(n - 1, k));
        return result;
    }

}
