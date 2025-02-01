package matrix.workingPeoplesImitation.task_3152_Special_Array_II;

// from leetcode editorial (Approach 3: Sliding Window)
public class Solution7 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] maxReach = new int[n];

        // Step 1: Compute the maximum reachable index for each starting index from last to first
        maxReach[n - 1] = n - 1; // The last index can only reach itself
        for (int i = n - 2; i >= 0; i--) {
            // Check if adjacent elements have different parity
            if ((nums[i] % 2) != (nums[i + 1] % 2)) {
                maxReach[i] = maxReach[i + 1]; // Extend the reach
            } else {
                maxReach[i] = i; // Can only reach itself
            }
        }

        boolean[] ans = new boolean[queries.length];

        // Step 2: Answer each query based on precomputed 'maxReach'
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            // Check if the query range [start, end] lies within the max reachable range
            ans[i] = end <= maxReach[start];
        }

        return ans;
    }
}
