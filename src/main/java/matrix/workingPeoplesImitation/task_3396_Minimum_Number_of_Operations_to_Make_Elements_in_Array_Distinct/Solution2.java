package matrix.workingPeoplesImitation.task_3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct;

import java.util.HashSet;

// from leetcode editorial (Approach 1: Simulation)
public class Solution2 {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i += 3, ans++) {
            if (checkUnique(nums, i)) {
                return ans;
            }
        }
        return ans;
    }

    private boolean checkUnique(int[] nums, int start) {
        HashSet<Integer> cnt = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (cnt.contains(nums[i])) {
                return false;
            }
            cnt.add(nums[i]);
        }
        return true;
    }
}
