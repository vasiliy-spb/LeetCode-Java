package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

// from leetcode editorial (Approach 4: Bit Manipulation + Dynamic Programming)
public class Solution9 {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        int[] dp = new int[1 << 17];

        // Initialize the empty subset
        dp[0] = 1;

        // Iterate through each number in the input array
        for (int num : nums) {
            for (int i = max; i >= 0; i--) {
                // For each existing subset, create a new subset by including the current number
                dp[i | num] += dp[i];
            }
            // Update the maximum OR value
            max |= num;
        }

        return dp[max];
    }
}
/*
Intuition

If we replace the OR operation with addition, this problem resembles the classic Knapsack Problem
(https://leetcode.com/discuss/study-guide/1152328/01-Knapsack-Problem-and-Dynamic-Programming),
a well-known dynamic programming challenge.

We create a dp array of size 217, where dp[i] represents the number of subsets with a cumulative OR value of i.
The base case is dp[0] = 1, since the only subset with an OR value of 0 is the empty subset.
We also track the maximum cumulative OR found during the process with a variable max, initially set to 0.
Why use such a large size?

To fill dp, we iterate over nums. For each value in nums,
we OR it with all the possible subset OR values we might have achieved till now.
This is basically all the values between 0 and max.
So, we iterate a variable i from max to 0 backward, and add the count of subsets in dp[i] to dp[i | num].
The backward iteration prevents double counting.
If we went forward, we might update a value and then use that updated value in the same iteration,
leading to incorrect counts.

By the end, max holds the maximum OR value, and dp[max] gives the number of subsets achieving this maximum OR.
 */