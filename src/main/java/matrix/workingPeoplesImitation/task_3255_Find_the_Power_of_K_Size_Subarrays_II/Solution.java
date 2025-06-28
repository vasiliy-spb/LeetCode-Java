package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// my solution
public class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixAscending = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefixAscending[i] += (nums[i] - nums[i - 1]) == 1 ? 1 : 0;
            }
            prefixAscending[i + 1] += prefixAscending[i];
        }
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            if (prefixAscending[i + k - 1] - prefixAscending[i] >= k - 1) {
                ans[i] = nums[i + k - 1];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
