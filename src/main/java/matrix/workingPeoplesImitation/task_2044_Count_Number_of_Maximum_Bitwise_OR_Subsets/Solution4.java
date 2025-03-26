package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

import java.util.*;

// my solution (accepted) 57 ms — best of my solutions
public class Solution4 {
    public int countMaxOrSubsets(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        backtrack(nums, 0, 0, map);
        return map.lastEntry().getValue();
    }

    private void backtrack(int[] nums, int start, int current, Map<Integer, Integer> map) {
        map.merge(current, 1, Integer::sum);
        for (int i = start; i < nums.length; i++) {
            int prev = current;
            current |= nums[i];
            backtrack(nums, i + 1, current, map);
            current = prev;
        }
    }
}
