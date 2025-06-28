package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// from leetcode code sample (17)
public class Solution19 {
    public int[] resultsArray(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = nums[i] == nums[i - 1] + 1 ? dp[i - 1] + 1 : 1;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; ++i) {
            res[i - k + 1] = dp[i] >= k ? nums[i] : -1;
        }
        return res;
    }
}
