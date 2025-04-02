package matrix.workingPeoplesImitation.task_2873_Maximum_Value_of_an_Ordered_Triplet_I;

// from leetcode editorial (Approach 2: Greedy)
public class Solution3 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int k = 2; k < n; k++) {
            int maxPrefix = nums[0];
            for (int j = 1; j < k; j++) {
                res = Math.max(res, (long) (maxPrefix - nums[j]) * nums[k]);
                maxPrefix = Math.max(maxPrefix, nums[j]);
            }
        }
        return res;
    }
}
