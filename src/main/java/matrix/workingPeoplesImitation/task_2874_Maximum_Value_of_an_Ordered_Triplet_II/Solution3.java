package matrix.workingPeoplesImitation.task_2874_Maximum_Value_of_an_Ordered_Triplet_II;

// from leetcode editorial (Approach 2: Greedy)
public class Solution3 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }
}
