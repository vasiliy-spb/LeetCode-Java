package matrix.workingPeoplesImitation.task_746_Min_Cost_Climbing_Stairs;

public class Solution {

    // my solution
    // hint 1: Build an array dp where dp[i] is the minimum cost to climb to the top starting from the ith staircase.
    // hint 2: Assuming we have n staircase labeled from 0 to n - 1 and assuming the top is n, then dp[n] = 0, marking that if you are at the top, the cost is 0.
    // hint 3: Now, looping from n - 1 to 0, the dp[i] = cost[i] + min(dp[i + 1], dp[i + 2]). The answer will be the minimum of dp[0] and dp[1]
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        for (int i = cost.length - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
//        System.out.println(Arrays.toString(dp));
        return Math.min(dp[0],dp[1]);
    }

    // from walkccc.me
    public int minCostClimbingStairs1(int[] cost) {
        final int n = cost.length;

        for (int i = 2; i < n; ++i)
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);

        return Math.min(cost[n - 1], cost[n - 2]);
    }

}
