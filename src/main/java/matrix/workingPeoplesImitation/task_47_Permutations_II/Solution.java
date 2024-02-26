package matrix.workingPeoplesImitation.task_47_Permutations_II;

import java.util.*;

public class Solution {

    // my solution
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        makePermutation(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result.stream().toList();
    }

    private void makePermutation(Set<List<Integer>> result, int[] nums, List<Integer> currentList, boolean[] used) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                currentList.add(nums[i]);
                used[i] = true;
                makePermutation(result, nums, currentList, used);
                currentList.remove(currentList.size() - 1);
                used[i] = false;
            }
        }
    }

    // from walkccc.me
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, used, path, ans);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
