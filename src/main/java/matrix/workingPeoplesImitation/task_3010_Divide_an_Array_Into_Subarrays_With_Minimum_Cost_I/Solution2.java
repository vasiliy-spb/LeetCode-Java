package matrix.workingPeoplesImitation.task_3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I;

import java.util.Arrays;

// from leetcode code sample (1)
public class Solution2 {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums, 1, nums.length);
        return nums[0] + nums[1] + nums[2];
    }
}
