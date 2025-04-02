package matrix.workingPeoplesImitation.task_2873_Maximum_Value_of_an_Ordered_Triplet_I;

// from leetcode editorial (Approach 4: Greedy)
public class Solution5 {
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
