package matrix.workingPeoplesImitation.task_2873_Maximum_Value_of_an_Ordered_Triplet_I;

// from leetcode editorial (Approach 1: Brute-force enumeration)
public class Solution2 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return res;
    }
}
