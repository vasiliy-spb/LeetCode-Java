package matrix.workingPeoplesImitation.task_3903_Smallest_Stable_Index_I;

// my solution
public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int min = nums[n - 1];
        for (int i = 0; i < n; i++) {
            prefixMax[i] = nums[i];
            if (i > 0 && prefixMax[i] < prefixMax[i - 1]) {
                prefixMax[i] = prefixMax[i - 1];
            }
        }
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (prefixMax[i] - min <= k) {
                ans = i;
            }
        }
        return ans;
    }
}
