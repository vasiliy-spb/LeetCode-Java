package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

import java.util.*;

// my solution (accepted) 474 ms
public class Solution2 {
    public int countMaxOrSubsets(int[] nums) {
        Set<Set<Integer>> subArrays = new HashSet<>();
        backtrack(nums, 0, new HashSet<>(), subArrays);
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Set<Integer> indexList : subArrays) {
            int subArrayOR = getWholeSubArrayOR(nums, indexList);
            map.merge(subArrayOR, 1, Integer::sum);
            max = Math.max(max, map.get(subArrayOR));
        }
        return max;
    }

    private void backtrack(int[] nums, int start, Set<Integer> currentList, Set<Set<Integer>> subArrays) {
        subArrays.add(new HashSet<>(currentList));
        for (int i = start; i < nums.length; i++) {
            currentList.add(i);
            backtrack(nums, i + 1, new HashSet<>(currentList), subArrays);
            currentList.remove(i);
        }
    }

    private int getWholeSubArrayOR(int[] nums, Set<Integer> indexList) {
        int ans = 0;
        for (int index : indexList) {
            ans |= nums[index];
        }
        return ans;
    }
}
