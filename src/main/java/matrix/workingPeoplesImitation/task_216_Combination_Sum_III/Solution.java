package matrix.workingPeoplesImitation.task_216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // my solution
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    private void findCombinations(List<List<Integer>> result, List<Integer> currentList, int k, int n, int start) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i <= n && k > 0) {
                currentList.add(i);
                findCombinations(result, currentList,  k - 1, n - i, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    // my solution
    public List<List<Integer>> combinationSum30(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result, new ArrayList<>(), 0, k, n, 1);
        return result;
    }

    private void findCombinations(List<List<Integer>> result, List<Integer> currentList, int currentSum, int k, int n, int start) {
        if (n == 0 || k == 0) return;
        for (int i = start; i <= 9; i++) {
            if (currentSum + i > n) break;
            if (k == 1 && currentSum + i == n) {
                currentList.add(i);
                result.add(new ArrayList<>(currentList));
                return;
            }
            if (currentSum + i < n && k > 1) {
                List<Integer> list = new ArrayList<>(currentList);
                list.add(i);
                findCombinations(result, list, currentSum + i, k - 1, n, i + 1);
            }
        }
    }

    // from walkccc.me
    public List<List<Integer>> combinationSum31(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int k, int n, int s, List<Integer> path, List<List<Integer>> ans) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (k == 0 || n < 0)
            return;

        for (int i = s; i <= 9; ++i) {
            path.add(i);
            dfs(k - 1, n - i, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    // from leetcode solutions
    public List<List<Integer>> combinationSum32(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
