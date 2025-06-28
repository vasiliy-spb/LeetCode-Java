package matrix.workingPeoplesImitation.task_78_Subsets;

import java.util.*;

public class Solution {

    // my solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> container = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            backtrack(nums, result, container, new TreeSet<>(), i);
        }
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, Set<String> container, TreeSet<Integer> current, int y) {
        String key = generateKey(current);
        if (!container.contains(key)) {
            result.add(current.stream().toList());
            container.add(key);
        }
        for (int i = y; i < nums.length; i++) {
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                if (i < nums.length - 1) backtrack(nums, result, container, new TreeSet<>(current), i + 1);
                else backtrack(nums, result, container, new TreeSet<>(current), 0);
                current.remove(nums[i]);
            }
        }
    }

    private String generateKey(Set<Integer> set) {
        StringBuilder result = new StringBuilder();
        for (int i : set)
            result.append(i);
        return result.toString();
    }

    // from walkccc.me
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int s, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));

        for (int i = s; i < nums.length; ++i) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
