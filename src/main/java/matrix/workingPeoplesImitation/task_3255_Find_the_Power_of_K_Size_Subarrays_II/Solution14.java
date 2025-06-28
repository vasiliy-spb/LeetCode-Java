package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.Deque;
import java.util.LinkedList;

// from leetcode code sample (12)
public class Solution14 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();

        // Step 1: Compute the DP array to check for consecutive sequences
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }

        // Step 2: Use a sliding window approach to compute results
        for (int i = 0; i < n; i++) {
            // Maintain deque for the maximum element in the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // When we've filled the window
            if (i >= k - 1) {
                // Check if the subarray [i - k + 1, i] is valid (consecutive and sorted)
                if (dp[i] >= k - 1) {
                    results[i - k + 1] = nums[deque.peekFirst()];
                } else {
                    results[i - k + 1] = -1;
                }
            }
        }

        return results;
    }
}
