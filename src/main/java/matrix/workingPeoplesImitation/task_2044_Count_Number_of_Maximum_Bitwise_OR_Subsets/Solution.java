package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

import java.util.*;

// my solution (accepted) 650 ms
public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        Set<List<Integer>> subArrays = new HashSet<>();
        backtrack(nums, 0, new ArrayList<>(), subArrays);
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> indexList : subArrays) {
            int subArrayOR = getWholeSubArrayOR(nums, indexList);
            map.merge(subArrayOR, 1, Integer::sum);
            max = Math.max(max, map.get(subArrayOR));
        }
        return max;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> currentList, Set<List<Integer>> subArrays) {
        subArrays.add(currentList);
        for (int i = start; i < nums.length; i++) {
            currentList.add(i);
            backtrack(nums, i + 1, new ArrayList<>(currentList), subArrays);
            currentList.remove(currentList.size() - 1);
        }
    }

    private int getWholeSubArrayOR(int[] nums, List<Integer> indexList) {
        int ans = 0;
        for (int index : indexList) {
            ans |= nums[index];
        }
        return ans;
    }
}
