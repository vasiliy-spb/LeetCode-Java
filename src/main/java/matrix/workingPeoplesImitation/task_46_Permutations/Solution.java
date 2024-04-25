package matrix.workingPeoplesImitation.task_46_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    // my solution
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void generatePermutations(int[] nums, List<List<Integer>> result, List<Integer> currentList, boolean[] used) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                currentList.add(nums[i]);
                used[i] = true;
                generatePermutations(nums, result, currentList, used);
                currentList.remove(currentList.size() - 1);
                used[i] = false;
            }
        }
    }

    // my solution
    public List<List<Integer>> permute0(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations0(nums, result, new ArrayList<>());
        return result;
    }

    private void generatePermutations0(int[] nums, List<List<Integer>> result, List<Integer> currentList) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!currentList.contains(nums[i])) {
                currentList.add(nums[i]);
                generatePermutations0(nums, result, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    // from walkccc.me
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

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
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, used, path, ans);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // from leetcode solutions
    public List<List<Integer>> permute3(int[] nums) {
        return permute(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    private List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.size() == 0) {
            return permutations;
        }
        if (nums.size() == 1) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(nums.get(0));
            permutations.add(permutation);
            return permutations;
        }

        List<List<Integer>> smallPermutations = permute(nums.subList(1, nums.size()));
        int first = nums.get(0);
        for(List<Integer> permutation : smallPermutations) {
            for (int i = 0; i <= permutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(i, first);
                permutations.add(newPermutation);
            }
        }
        return permutations;
    }

    // from leetcode (https://leetcode.com/submissions/detail/1238871694/) решение https://leetcode.com/Iregor/
    public List<List<Integer>> permute4(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        getPermuteRec(permutes, nums, 0);
        return permutes;
    }

    private void getPermuteRec(List<List<Integer>> permutes, int[] nums, int p) {
        if (p == nums.length) {
            List<Integer> permute = new ArrayList<>();
            for (int number : nums) {
                permute.add(number);
            }
            permutes.add(permute);
        }
        for (int i = p; i < nums.length; i++) {
            swap(nums, p, i);
            getPermuteRec(permutes, nums, p + 1);
            swap(nums, p, i);
        }
    }

    private void swap(int[] arr, int p1, int p2) {
        if (p1 == p2) {
            return;
        }

        arr[p1] += arr[p2];
        arr[p2] = arr[p1] - arr[p2];
        arr[p1] -= arr[p2];
    }
}
