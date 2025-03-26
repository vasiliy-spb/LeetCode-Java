package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

import java.util.*;

// my solution (accepted) 96 ms
public class Solution3 {
    public int countMaxOrSubsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        backtrack(nums, 0, 0, ans);
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : ans) {
            map.merge(a, 1, Integer::sum);
            max = Math.max(max, map.get(a));
        }
        return max;
    }

    private void backtrack(int[] nums, int start, int current, List<Integer> ans) {
        ans.add(current);
        for (int i = start; i < nums.length; i++) {
            int prev = current;
            current |= nums[i];
            backtrack(nums, i + 1, current, ans);
            current = prev;
        }
    }
}
