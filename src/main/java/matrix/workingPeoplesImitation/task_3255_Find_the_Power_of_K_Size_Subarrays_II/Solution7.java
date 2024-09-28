package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// from leetcode code sample (5)
public class Solution7 {
    public int[] resultsArray(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k; i <= nums.length; i++) {
            long x = (long) (nums[i - 1] + nums[i - k]) * (long) (k) / 2L;
            if (nums[i - 1] - nums[i - k] == k - 1 && prefixSum[i] - prefixSum[i - k] == x) {
                res[i - k] = nums[i - 1];
            } else {
                res[i - k] = -1;
            }
        }
        return res;
    }
}
