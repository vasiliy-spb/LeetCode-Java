package matrix.workingPeoplesImitation.task_198_House_Robber;

import java.util.Arrays;

public class Solution {

    // my solution
    public int rob(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int[] dp = new int[nums.length + 3];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = nums[i] + Math.max(dp[i + 2], dp[i + 3]);
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[0],dp[1]);
    }

    // from walkccc.me (Approach 1: 1D DP)
    public int rob1(int[] nums) {
        final int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        // dp[i] := the maximum money of robbing nums[0..i]
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; ++i)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return dp[n - 1];
    }

    // from walkccc.me (Approach 2: O(1) DP)
    public int rob2(int[] nums) {
        int prev1 = 0; // dp[i - 1]
        int prev2 = 0; // dp[i - 2]

        for (final int num : nums) {
            final int dp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }

}
